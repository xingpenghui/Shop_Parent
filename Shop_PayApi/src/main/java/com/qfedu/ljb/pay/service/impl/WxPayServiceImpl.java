package com.qfedu.ljb.pay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.qfedu.common.util.Base64Util;
import com.qfedu.common.vo.R;
import com.qfedu.ljb.pay.core.config.SystemCofig;
import com.qfedu.ljb.pay.core.wxchat.PayCommonUtil;
import com.qfedu.ljb.pay.core.wxchat.XmlUtil;
import com.qfedu.ljb.pay.db.entity.TOplog;
import com.qfedu.ljb.pay.db.entity.TOrderpay;
import com.qfedu.ljb.pay.db.entity.TOrderqrcode;
import com.qfedu.ljb.pay.db.service.TOplogService;
import com.qfedu.ljb.pay.db.service.TOrderpayService;
import com.qfedu.ljb.pay.db.service.TOrderqrcodeService;
import com.qfedu.ljb.pay.entity.WxPay;
import com.qfedu.ljb.pay.enumconfig.LogType;
import com.qfedu.ljb.pay.service.WxPayService;
import org.jdom.JDOMException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/6/27 11:31
 */
@Service
public class WxPayServiceImpl implements WxPayService {
    @Autowired
    private TOrderpayService orderpayService;
    @Autowired
    private TOplogService logService;
    @Autowired
    private TOrderqrcodeService qrcodeService;
    @Override
    public R orderPay(WxPay pay) {
            //验证当前的订单号是否有过支付记录
           TOrderpay orderpay= orderpayService.getOne(new QueryWrapper<TOrderpay>().eq("orderno",pay.getOrderNo()));
           boolean isPay=false;
           if(orderpay!=null){
                //之前有支付记录
                if(orderpay.getFlag()==1){
                    //目前有支付信息  获取最新的支付二维码信息
                   TOrderqrcode tOrderqrcode=qrcodeService.selectLast(orderpay.getId());
                   //验证二维码是否有效
                    //有效就返回
                    if(tOrderqrcode.getFlag()==1){
                        saveLog(pay.getOrderNo(),1,"该订单支付链接可用");
                        return R.setOK("支付二维码OK",tOrderqrcode.getQrcodeurl());
                    }else {
                        //无效就重新接口 生成
                        isPay=true;
                    }
                }else {
                    saveLog(pay.getOrderNo(),1,"该订单已经交易结束");
                    return R.setERROR("该订单已经交易结束");
                }
            }else {
               isPay=true;
           }
            if(isPay){
                try {
                    String url=PayCommonUtil.weixin_pay(pay.getPrice()+"",pay.getOrderinfo(),pay.getOrderNo());
                    if(url!=null && url.length()>0){
                        String m=Base64Util.base64Enc(url.getBytes());
                        TOrderpay orderpay1=new TOrderpay();
                        orderpay1.setCtime(new Date());
                        orderpay1.setFlag(1);
                        orderpay1.setMoney(pay.getPrice());
                        orderpay1.setOrderno(pay.getOrderNo());
                        orderpay1.setProject("邻家邦");
                        orderpayService.save(orderpay1);
                        TOrderqrcode orderqrcode=new TOrderqrcode();
                        orderqrcode.setOpid(orderpay1.getId());
                        orderqrcode.setCtime(new Date());
                        orderqrcode.setPayurl(url);
                        orderqrcode.setQrcodeurl(SystemCofig.PAYURL+"qrcode/payqrcode.do?msg="+m);
                        orderqrcode.setFlag(1);
                        qrcodeService.save(orderqrcode);
                        saveLog(pay.getOrderNo(),1,"生成支付二维码连接");
                        return R.setOK("支付二维码生成",orderqrcode.getQrcodeurl());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    saveLog(pay.getOrderNo(),1,"生成支付二维码异常："+e.getMessage());
                }
                return R.setERROR("网络异常，暂无法支付，请人工支付");
            }
            return null;
    }
    private void saveLog(String orderNo,int type,String content){
        TOplog tOplog=new TOplog();
        tOplog.setOrderno(orderNo);
        tOplog.setType(type);
        tOplog.setContent(content);
        tOplog.setCtime(new Date());
        logService.save(tOplog);
    }

    @Override
    public R queryOrder(String orderNo) {
        String xml=PayCommonUtil.weixin_query(orderNo);
        try {
            Map<String,Object> map=XmlUtil.doXMLParse(xml);
            if(map.containsKey("trade_state")){
                String r=map.get("trade_state").toString();
                saveLog(orderNo,LogType.querypay.getValue(),"订单支付完成："+r);
                return R.setOK("查询成功",r);
            }else {
                saveLog(orderNo,LogType.querypay.getValue(),"订单支付状态查询失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
            saveLog(orderNo,LogType.querypay.getValue(),"订单支付状态查询结果解析异常");
        }
        return R.setERROR("服务器异常");
    }

    @Override
    public R closeOrder(String orderNo) {
        String xml=PayCommonUtil.closeOrder(orderNo);
        if(xml!=null && xml.length()>0){
            try {
                Map<String,Object> map=XmlUtil.doXMLParse(xml);
                if(map.containsKey("result_code")){
                    return R.setOK("操作成功",map.get("result_code"));
                }
            } catch (JDOMException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return R.setERROR("网络异常，请稍后再查");
    }
}

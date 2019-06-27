package com.qfedu.ljb.pay.service.impl;

import com.qfedu.common.util.Base64Util;
import com.qfedu.common.vo.R;
import com.qfedu.ljb.pay.core.config.SystemCofig;
import com.qfedu.ljb.pay.core.wxchat.PayCommonUtil;
import com.qfedu.ljb.pay.core.wxchat.XmlUtil;
import com.qfedu.ljb.pay.entity.WxPay;
import com.qfedu.ljb.pay.service.WxPayService;
import org.jdom.JDOMException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/6/27 11:31
 */
@Service
public class WxPayServiceImpl implements WxPayService {
    @Override
    public R orderPay(WxPay pay) {
        try {
            String url=PayCommonUtil.weixin_pay(pay.getPrice()+"",pay.getOrderinfo(),pay.getOrderNo());
            if(url!=null && url.length()>0){
                String m=Base64Util.base64Enc(url.getBytes());
                return R.setOK("支付二维码生成",SystemCofig.PAYURL+"qrcode/payqrcode.do?msg="+m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return R.setERROR("网络异常，暂无法支付，请人工支付");
    }

    @Override
    public R queryOrder(String orderno) {
        String xml=PayCommonUtil.weixin_query(orderno);
        try {
            Map<String,Object> map=XmlUtil.doXMLParse(xml);
            if(map.containsKey("trade_state")){
                String r=map.get("trade_state").toString();
//                switch (r){
////                    case "SUCCESS":
////                        break;
////                }
                return R.setOK("查询成功",r);
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
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

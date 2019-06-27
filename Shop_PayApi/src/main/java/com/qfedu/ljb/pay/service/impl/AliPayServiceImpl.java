package com.qfedu.ljb.pay.service.impl;

import com.alipay.api.AlipayApiException;
import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.util.Base64Util;
import com.qfedu.common.vo.R;
import com.qfedu.ljb.pay.core.alipay.AlipayUtil;
import com.qfedu.ljb.pay.core.config.SystemCofig;
import com.qfedu.ljb.pay.entity.AliPay;
import com.qfedu.ljb.pay.service.AliPayService;
import org.springframework.stereotype.Service;

import java.util.Base64;

/**
 *@Author feri
 *@Date Created in 2019/6/27 15:12
 */
@Service
public class AliPayServiceImpl implements AliPayService {
    @Override
    public R orderPay(AliPay pay) {
        try {
            String u=AlipayUtil.orderPay(pay);
            if(u!=null && u.length()>0){
                String m=Base64Util.base64Enc(u.getBytes());
                return R.setOK("支付宝预支付链接成功",SystemCofig.PAYURL+"qrcode/payqrcode.do?msg="+m);
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        return R.setERROR("网络异常，请联系客服");
    }

    @Override
    public R checkPay(String orderNo) {
        try {
            String u=AlipayUtil.checkPay(orderNo);
            if(u!=null && u.length()>0){
                return R.setOK("查询成功",u);
            }
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }

        return R.setERROR("网络异常，暂无法查询");
    }
}

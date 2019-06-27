package com.qfedu.ljb.pay.core.test;

import com.alipay.api.AlipayApiException;
import com.qfedu.ljb.pay.core.alipay.AlipayUtil;
import com.qfedu.ljb.pay.entity.AliPay;
import com.qfedu.ljb.pay.entity.WxPay;
import org.junit.Test;

/**
 *@Author feri
 *@Date Created in 2019/6/27 15:07
 */
public class AliPay_Test {
    @Test
    public void test1() throws AlipayApiException {
        AliPay pay=new AliPay();
        pay.setOut_trade_no("20190627021");
        pay.setSubject("我要学习");
        pay.setTotal_amount(0.01);
        System.out.println(AlipayUtil.orderPay(pay));
    }
}

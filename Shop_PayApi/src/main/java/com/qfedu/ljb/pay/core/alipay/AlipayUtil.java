package com.qfedu.ljb.pay.core.alipay;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeCloseRequest;
import com.alipay.api.request.AlipayTradePrecreateRequest;
import com.alipay.api.request.AlipayTradeQueryRequest;
import com.alipay.api.response.AlipayTradeCloseResponse;
import com.alipay.api.response.AlipayTradePrecreateResponse;
import com.alipay.api.response.AlipayTradeQueryResponse;
import com.qfedu.ljb.pay.entity.AliPay;
import com.qfedu.ljb.pay.entity.WxPay;

/**
 *@Author feri
 *@Date Created in 2019/6/27 14:39
 *封装支付宝支付相关操作
 */
public class AlipayUtil {
    public static AlipayClient alipayClient;
    static {
        alipayClient=new DefaultAlipayClient(
                PayConfig.PAY_URL ,PayConfig.APP_ID , PayConfig.APP_PRIVATE_KEY, "json","UTF-8", PayConfig.ALIPAY_PUBLIC_KEY, "RSA2"); //获得初始化的AlipayClient
    }

    //生成预支付链接  将信息写入到二维码
    public static String orderPay(AliPay pay) throws AlipayApiException {
        AlipayTradePrecreateRequest request = new AlipayTradePrecreateRequest();
        request.setBizContent(JSON.toJSONString(pay));
        AlipayTradePrecreateResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
           return response.getQrCode();
        } else {
           return null;
        }
    }
    //查询订单的交易状态
    public static String checkPay(String orderNo) throws AlipayApiException {
        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizContent("{\"out_trade_no\":"+orderNo+" }");
        AlipayTradeQueryResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
           return response.getTradeStatus();
        } else {
           return null;
        }
    }
    //关闭订单
    public static String close(String orderNo) throws AlipayApiException {
        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizContent("{\"out_trade_no\":"+orderNo+" }");
        AlipayTradeCloseResponse response = alipayClient.execute(request);
        if(response.isSuccess()){
            return response.getSubCode();
        } else {
           return null;
        }
    }




}

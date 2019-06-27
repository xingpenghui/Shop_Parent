package com.qfedu.ljb.pay.controller;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.pay.entity.WxPay;
import com.qfedu.ljb.pay.service.WxPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/6/27 11:31
 */
@RestController
public class WxPayController {
    @Autowired
    private WxPayService payService;

    //预支付接口
    @PostMapping("pay/wxchat/orderpay.do")
    public R orderPay(@RequestBody WxPay pay){
        return payService.orderPay(pay);
    }
    @GetMapping("pay/wxchat/orderstatus.do")
    public R query(String orderNo){
        return payService.queryOrder(orderNo);
    }
    @GetMapping("pay/wxchat/closepay.do")
    public R close(String orderNo){
        return payService.closeOrder(orderNo);
    }
}

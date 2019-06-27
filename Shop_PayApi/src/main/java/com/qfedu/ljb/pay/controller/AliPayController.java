package com.qfedu.ljb.pay.controller;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.pay.entity.AliPay;
import com.qfedu.ljb.pay.service.AliPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/6/27 15:15
 */
@RestController
public class AliPayController {
    @Autowired
    private AliPayService payService;

    @PostMapping("pay/alipay/orderpay.do")
    public R oderPay(@RequestBody AliPay pay){
        return payService.orderPay(pay);
    }
    @GetMapping("pay/alipay/checkpay.do")
    public R check(String orderNo){
        return payService.checkPay(orderNo);
    }
}

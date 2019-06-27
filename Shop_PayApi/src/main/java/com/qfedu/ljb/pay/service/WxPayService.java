package com.qfedu.ljb.pay.service;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.pay.entity.WxPay;

/**
 *@Author feri
 *@Date Created in 2019/6/27 11:30
 */
public interface WxPayService {

    //生成订单支付信息
    R orderPay(WxPay pay);

    //查询订单支付状态
    R queryOrder(String orderNo);

    //关闭订单
    R closeOrder(String orderNo);
}

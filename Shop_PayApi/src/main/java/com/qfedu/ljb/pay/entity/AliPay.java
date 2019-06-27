package com.qfedu.ljb.pay.entity;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/6/27 14:57
 */
@Data
public class AliPay {

    private String out_trade_no;//订单编号
    private double total_amount;//价格
    private String subject;//商品信息

}

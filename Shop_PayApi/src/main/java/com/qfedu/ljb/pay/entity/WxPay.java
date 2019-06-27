package com.qfedu.ljb.pay.entity;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/6/27 11:32
 */
@Data
public class WxPay {
    private String orderNo;
    private String orderinfo;
    private int price;

}

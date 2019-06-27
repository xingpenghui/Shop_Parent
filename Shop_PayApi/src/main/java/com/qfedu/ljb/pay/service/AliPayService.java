package com.qfedu.ljb.pay.service;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.pay.entity.AliPay;

/**
 *@Author feri
 *@Date Created in 2019/6/27 15:12
 */
public interface AliPayService {
    R orderPay(AliPay pay);
    R checkPay(String orderNo);
}

package com.qfedu.ljb.pay.enumconfig;

/**
 *@Author feri
 *@Date Created in 2019/6/27 16:45
 */
public enum LogType {
    prepay(1),querypay(2),closepay(3),refundpay(4),queryrefund(5),bill(6);
    private int value;
    private LogType(int value){
        this.value=value;
    }

    public int getValue() {
        return value;
    }
}

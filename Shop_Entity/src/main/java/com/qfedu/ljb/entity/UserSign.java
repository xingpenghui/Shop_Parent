package com.qfedu.ljb.entity;

import lombok.Data;

import java.math.BigInteger;
import java.util.Date;

/**
 *@Author feri
 *@Date Created in 2019/6/15 11:37
 */
@Data
public class UserSign {
    private BigInteger id;
    private int uid;
    private int score;
    private int extrascore;
    private int days;
    private Date createtime;
}

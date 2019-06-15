package com.qfedu.ljb.server.model;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/6/14 14:46
 */
@Data
public class LoginToken {
    private String id;
    private String phone;
    private int uid;
}

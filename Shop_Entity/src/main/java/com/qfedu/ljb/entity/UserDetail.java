package com.qfedu.ljb.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserDetail {
    private Integer id;
    private Integer uid;
    private String nickname;
    private Short sex;
    private Date birthday;
    private String headurl;
    private Date createtime;
}
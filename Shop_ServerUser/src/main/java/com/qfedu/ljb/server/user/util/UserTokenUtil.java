package com.qfedu.ljb.server.user.util;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.model.LoginToken;
import com.qfedu.ljb.entity.User;

/**
 *@Author feri
 *@Date Created in 2019/6/15 12:03
 */
public class UserTokenUtil {
    public static LoginToken parseToken(String json){
        if(json!=null){
            return JSON.parseObject(json,LoginToken.class);
        }else {
            return null;
        }
    }
    public static int parseTokenId(String json){
        if(json!=null){
            LoginToken user= JSON.parseObject(json,LoginToken.class);
            return user.getUid();
        }else {
            return 0;
        }
    }
    public static User parseUserToken(String json){
        if(json!=null){
            return JSON.parseObject(json,User.class);
        }else {
            return null;
        }
    }
    public static int parseUid(String json){
        if(json!=null){
            User user= JSON.parseObject(json,User.class);
            return user.getId();
        }else {
            return 0;
        }
    }
}

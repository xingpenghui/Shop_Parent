package com.qfedu.ljb.server.user.service;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.entity.UserSign;

/**
 *@Author feri
 *@Date Created in 2019/6/15 11:55
 */
public interface UserSignService {
    R saveSign(String token);
    R queryByDays(String token,int days);
    R queryByUid(String token);
    R querySingle(String token);

}

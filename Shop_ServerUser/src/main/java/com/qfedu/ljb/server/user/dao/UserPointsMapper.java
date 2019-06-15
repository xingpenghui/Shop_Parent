package com.qfedu.ljb.server.user.dao;

import com.qfedu.ljb.entity.UserPoints;
import org.apache.ibatis.annotations.Param;

public interface UserPointsMapper {
    int insert(UserPoints record);
    int update(@Param("uid")int uid,@Param("score") int score);

}
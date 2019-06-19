package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.GoodsCollect;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsCollectMapper {

    int insert(GoodsCollect record);

    List<GoodsCollect> selectByUid(int uid);

    int deleteByUid(@Param("uid") int uid,@Param("gid")int gid);
}
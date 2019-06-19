package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.GoodsDetail;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsDetailMapper {

    int insert(GoodsDetail record);

    GoodsDetail selectByGid(int gid);

   }
package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.GoodsType;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsTypeMapper {

    int insert(GoodsType record);

    List<GoodsType> selectAll();
    List<GoodsType> selectByLevel(int level);

}
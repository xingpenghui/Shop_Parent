package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.GoodsAttribute;
import java.util.List;

public interface GoodsAttributeMapper {
    int insert(String name);
    GoodsAttribute selectById(int id);
    List<GoodsAttribute> selectAll();
}
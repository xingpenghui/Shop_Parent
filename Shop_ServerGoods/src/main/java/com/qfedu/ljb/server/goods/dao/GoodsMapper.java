package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.Goods;
import java.util.List;
import java.util.Map;


public interface GoodsMapper {
    int insert(Goods record);
    List<Goods> selectAll(Map<String,Object> params);
    Goods selectById(int id);
}
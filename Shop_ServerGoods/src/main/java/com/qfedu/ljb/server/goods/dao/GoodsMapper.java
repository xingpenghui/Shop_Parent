package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.Goods;
import com.qfedu.ljb.server.goods.dto.GoodsDetailDto;
import com.qfedu.ljb.server.goods.dto.GoodsListDto;

import java.util.List;
import java.util.Map;


public interface GoodsMapper {
    int insert(Goods record);
    List<GoodsListDto> selectAll(Map<String,String> params);
    Goods selectById(int id);
    GoodsDetailDto selectDetail(int id);
}
package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.GoodsPrice;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsPriceMapper {

    int insert(GoodsPrice record);
}
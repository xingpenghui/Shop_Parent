package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.GoodsSku;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsSkuMapper {

    int insert(GoodsSku record);
}
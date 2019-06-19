package com.qfedu.ljb.server.goods.dao;

import com.qfedu.ljb.entity.GoodsRepertory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodsRepertoryMapper {

    int insert(GoodsRepertory record);
    int update(@Param("id") int id,@Param("count") int count);
}
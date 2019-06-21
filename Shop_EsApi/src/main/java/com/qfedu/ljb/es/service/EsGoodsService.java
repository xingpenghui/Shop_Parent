package com.qfedu.ljb.es.service;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.es.model.EsGoods;

/**
 *@Author feri
 *@Date Created in 2019/6/21 10:20
 */
public interface EsGoodsService {
    R save(EsGoods goods);
    R queryAll();
    void del(int id);
    R queryLike(String name);

}

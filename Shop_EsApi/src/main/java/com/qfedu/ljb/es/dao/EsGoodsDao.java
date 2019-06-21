package com.qfedu.ljb.es.dao;

import com.qfedu.ljb.es.model.EsGoods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 *@Author feri
 *@Date Created in 2019/6/21 10:14
 */
public interface EsGoodsDao extends ElasticsearchRepository<EsGoods,Integer> {
}

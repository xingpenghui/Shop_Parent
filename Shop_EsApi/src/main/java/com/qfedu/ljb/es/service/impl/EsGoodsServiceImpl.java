package com.qfedu.ljb.es.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.es.dao.EsGoodsDao;
import com.qfedu.ljb.es.model.EsGoods;
import com.qfedu.ljb.es.service.EsGoodsService;
import org.elasticsearch.index.query.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/6/21 10:21
 */
@Service
public class EsGoodsServiceImpl implements EsGoodsService {
    @Autowired
    private EsGoodsDao dao;
    @Override
    public R save(EsGoods goods) {
        if(dao.save(goods)!=null){
            return R.setOK();
        }else {
            return R.setERROR("网络异常");
        }
    }

    @Override
    public R queryAll() {
        return R.setOK("OK",dao.findAll());
    }

    @Override
    public void del(int id) {
        dao.deleteById(id);
    }

    @Override
    public R queryLike(String name) {
        if(name!=null && name.length()>0){
            name="*"+name+"*";
        }
        WildcardQueryBuilder wildcardQueryBuilder=QueryBuilders.wildcardQuery("name",name);
//        RangeQueryBuilder rangeQueryBuilder=QueryBuilders.rangeQuery("id");
//        rangeQueryBuilder.gt(10).lt(100);
//        BoolQueryBuilder boolQueryBuilder=QueryBuilders.boolQuery();
//        boolQueryBuilder.must(wildcardQueryBuilder).must(rangeQueryBuilder);
        return R.setOK("OK",dao.search(wildcardQueryBuilder));
    }
}

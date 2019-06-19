package com.qfedu.ljb.server.goods.service.impl;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.server.goods.dao.GoodsMapper;
import com.qfedu.ljb.server.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *@Author feri
 *@Date Created in 2019/6/19 09:57
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public R queryIndexNew() {
        return R.setOK("OK",goodsMapper.selectAll(null));
    }
}

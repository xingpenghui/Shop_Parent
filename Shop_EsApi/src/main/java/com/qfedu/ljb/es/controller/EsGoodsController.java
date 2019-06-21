package com.qfedu.ljb.es.controller;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.es.model.EsGoods;
import com.qfedu.ljb.es.service.EsGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *@Author feri
 *@Date Created in 2019/6/21 14:17
 */
@RestController
public class EsGoodsController  {
    @Autowired
    private EsGoodsService goodsService;

    @PostMapping("es/goodsadd.do")
    public R save(@RequestBody EsGoods goods){
        return goodsService.save(goods);
    }
    @GetMapping("es/goodsall.do")
    public R all(){
        return goodsService.queryAll();
    }
    @GetMapping("es/goodslike.do")
    public R like(String name){
        return goodsService.queryLike(name);
    }

}

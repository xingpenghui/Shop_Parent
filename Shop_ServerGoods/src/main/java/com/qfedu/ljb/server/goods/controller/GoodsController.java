package com.qfedu.ljb.server.goods.controller;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.server.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/6/19 09:57
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;


    @GetMapping("goods/indexnew.do")
    public R newGoods(){
        return goodsService.queryIndexNew();
    }

    @PostMapping("goods/page.do")
    public R page(@RequestBody Map<String,String> map){
        return goodsService.queryPage(map);
    }
    @GetMapping("goods/detail.do")
    public R detail(int id){
        return goodsService.queryDetail(id);
    }
}

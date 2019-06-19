package com.qfedu.ljb.api.controller;

import com.qfedu.common.vo.R;
import com.qfedu.ljb.api.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/6/19 17:11
 */
@RestController
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("goods/indexnew.do")
    public R newGoods(){
        return goodsService.newGoods();
    }

    @PostMapping("goods/page.do")
    public R page(@RequestBody Map<String,String> map){
        return goodsService.page(map);
    }
    @GetMapping("goods/detail.do")
    public R detail(int id){
        return goodsService.detail(id);
    }
}

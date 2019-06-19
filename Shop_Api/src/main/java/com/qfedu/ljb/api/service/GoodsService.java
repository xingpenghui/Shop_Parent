package com.qfedu.ljb.api.service;

import com.qfedu.common.vo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 *@Author feri
 *@Date Created in 2019/6/19 17:10
 */
@FeignClient(name = "GoodsProvider")
public interface GoodsService {

    @GetMapping("goods/indexnew.do")
    R newGoods();

    @PostMapping("goods/page.do")
    R page(@RequestBody Map<String,String> map);
    @GetMapping("goods/detail.do")
    R detail(int id);
}

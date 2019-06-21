package com.qfedu.ljb.server.goods.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qfedu.common.vo.PageBean;
import com.qfedu.common.vo.R;
import com.qfedu.ljb.server.goods.dao.GoodsMapper;
import com.qfedu.ljb.server.goods.dto.GoodsListDto;
import com.qfedu.ljb.server.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;

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

    @Override
    public R queryPage(Map<String, String> map) {
        int page=Integer.parseInt(map.get("page"));
        int count=Integer.parseInt(map.get("count"));
        PageHelper.startPage(page,count);
        PageInfo<GoodsListDto> pageInfo=new PageInfo<GoodsListDto>(goodsMapper.selectAll(map));
        PageBean<GoodsListDto> pageBean=new PageBean();
        pageBean.setCount(count);
        pageBean.setCurrPage(page);
        pageBean.setTotalCount((int) pageInfo.getTotal());
        pageBean.setTotalPage(pageInfo.getPages());
        pageBean.setData(pageInfo.getList());
        return R.setOK("OK",pageBean);
    }

    @Override
    public R queryDetail(int id) {
        return R.setOK("OK",goodsMapper.selectDetail(id));
    }
}

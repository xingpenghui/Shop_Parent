package com.qfedu.ljb.pay.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qfedu.common.vo.R;
import com.qfedu.ljb.pay.db.entity.TOrderpay;
import com.qfedu.ljb.pay.db.service.TOplogService;
import com.qfedu.ljb.pay.db.service.TOrderpayService;
import com.qfedu.ljb.pay.db.service.TOrderqrcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/6/27 16:58
 */
@RestController
public class PayController {
    @Autowired
    private TOrderpayService orderpayService;
    @Autowired
    private TOplogService logService;
    @Autowired
    private TOrderqrcodeService qrcodeService;

    //查询支付记录
    @GetMapping("pay/data/orderpay/page.do")
    public R pagePay(int page,int count){
        List<TOrderpay> list=orderpayService.page(new Page<TOrderpay>((page-1)*count,count)).getRecords();
        return R.setOK("OK",list);
    }
    @GetMapping("pay/data/orderpage/detail.do")
    public R detail(String orderNo){
        return R.setOK("OK",orderpayService.getOne(new QueryWrapper<TOrderpay>().eq("orderno",orderNo)));
    }
    @GetMapping("pay/data/log/all.do")
    public R all(){
        return R.setOK("OK",logService.list());
    }

}

package com.qfedu.ljb.es.task;

import com.alibaba.fastjson.JSON;
import com.qfedu.common.config.ProjectConfig;
import com.qfedu.common.util.JedisUtil;
import com.qfedu.ljb.es.model.EsGoods;
import com.qfedu.ljb.es.service.EsGoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *@Author feri
 *@Date Created in 2019/6/21 15:34
 * 基于Spring Task 实现es服务器数据的同步
 * 从Redis 间隔4小时
 */
@Component
public class EsDataGoodsTask {
    @Autowired
    private JedisUtil jedisUtil;
    @Autowired
    private EsGoodsService goodsService;
    @Scheduled(cron = "0 0 0/4 * * ?")
    public void dataSync(){
        //实现数据同步
        //从-Redis-ES
        //新增
        //验证Redis  记录的新增商品的Key是否存在
        if(jedisUtil.exists(ProjectConfig.ESGOODSADD)){
            readToSave(jedisUtil.hgetall(ProjectConfig.ESGOODSADD),1);
        }else {
            //不存在，验证备份Key
            if(jedisUtil.exists(ProjectConfig.ESGOODSADDBU)){
                //记录日志
               readToSave(jedisUtil.hgetall(ProjectConfig.ESGOODSADDBU),1);
            }
        }
        //修改
        if(jedisUtil.exists(ProjectConfig.ESGOODSUPDATE)){
            readToSave(jedisUtil.hgetall(ProjectConfig.ESGOODSUPDATE),2);
        }else {
            //记录
            if(jedisUtil.exists(ProjectConfig.ESGOODSUPDATEBU)){
                readToSave(jedisUtil.hgetall(ProjectConfig.ESGOODSUPDATEBU),2);
            }
        }
        //删除
        if(jedisUtil.exists(ProjectConfig.ESGOODSDELETE)){
            del(jedisUtil.hgetall(ProjectConfig.ESGOODSDELETE));
        }else {
            //记录
            if(jedisUtil.exists(ProjectConfig.ESGOODSDELETEBU)){
                del(jedisUtil.hgetall(ProjectConfig.ESGOODSDELETEBU));
            }
        }
    }
    //新增或修改 type: 1新增 2修改
    private void readToSave(Map<String,String> map,int type){
        if(map!=null){
            Collection<String> list=map.values();
            for(String j:list){
                goodsService.save(JSON.parseObject(j,EsGoods.class));
            }
            //存储之后，记得清理key
            if(type==1){
                jedisUtil.del(ProjectConfig.ESGOODSADD,ProjectConfig.ESGOODSADDBU);
            }else  if(type==2){
                jedisUtil.del(ProjectConfig.ESGOODSUPDATE,ProjectConfig.ESGOODSUPDATEBU);
            }

        }
    }
    //删除
    public void del(Map<String,String> map){
        if(map!=null){
            Set<String> set =map.keySet();
            for(String id:set){
                goodsService.del(Integer.parseInt(id));
            }
            //存储之后，记得清理key
            jedisUtil.del(ProjectConfig.ESGOODSDELETE,ProjectConfig.ESGOODSDELETEBU);
        }
    }
}

package com.qfedu.ljb.es.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 *@Author feri
 *@Date Created in 2019/6/21 10:06
 */
@Data
@Document(indexName = "ljb:allgoods",type = "esgoods",shards = 5)
public class EsGoods {
//    @Id
    private Integer id;
//    @Field()
    private String name;
    private String gtype;
}

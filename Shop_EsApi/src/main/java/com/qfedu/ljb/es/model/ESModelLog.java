package com.qfedu.ljb.es.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 *@Author feri
 *@Date Created in 2019/6/21 15:59
 * 操作ES的异常日志
 */
@Document(indexName = "eserrorlog",type = "esmodellog")
public class ESModelLog {
    @Id
    private Integer id;
    private String content;
}

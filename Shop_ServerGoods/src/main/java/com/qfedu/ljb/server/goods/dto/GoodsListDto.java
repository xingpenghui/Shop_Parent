package com.qfedu.ljb.server.goods.dto;

import lombok.Data;

/**
 *@Author feri
 *@Date Created in 2019/6/19 15:50
 */
@Data
public class GoodsListDto {
    private Integer id;

    private String name;

    private Integer gtid;

    private String brand;

    private String discount;

    private Integer flag;

    private String picurl;
    private int minprice;
    private int paycount;
}

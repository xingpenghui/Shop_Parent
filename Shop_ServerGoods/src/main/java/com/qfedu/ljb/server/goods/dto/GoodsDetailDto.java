package com.qfedu.ljb.server.goods.dto;

import lombok.Data;

import java.util.List;

/**
 *@Author feri
 *@Date Created in 2019/6/19 16:46
 */
@Data
public class GoodsDetailDto extends GoodsListDto {
    private List<GoodsSkuDto> skuDtoList;
}

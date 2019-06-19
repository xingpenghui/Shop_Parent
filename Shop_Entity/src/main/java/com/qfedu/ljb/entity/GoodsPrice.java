package com.qfedu.ljb.entity;

public class GoodsPrice {
    private Integer id;

    private Integer gid;

    private String skuids;

    private Integer currprice;

    private Integer oldprice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getSkuids() {
        return skuids;
    }

    public void setSkuids(String skuids) {
        this.skuids = skuids == null ? null : skuids.trim();
    }

    public Integer getCurrprice() {
        return currprice;
    }

    public void setCurrprice(Integer currprice) {
        this.currprice = currprice;
    }

    public Integer getOldprice() {
        return oldprice;
    }

    public void setOldprice(Integer oldprice) {
        this.oldprice = oldprice;
    }
}
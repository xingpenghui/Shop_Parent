package com.qfedu.ljb.entity;

public class Cart {
    private Integer id;

    private Integer uid;

    private Integer maxcount;

    private Integer currcount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getMaxcount() {
        return maxcount;
    }

    public void setMaxcount(Integer maxcount) {
        this.maxcount = maxcount;
    }

    public Integer getCurrcount() {
        return currcount;
    }

    public void setCurrcount(Integer currcount) {
        this.currcount = currcount;
    }
}
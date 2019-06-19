package com.qfedu.ljb.entity;

public class GoodsSku {
    private Integer id;

    private Integer gid;

    private Integer gaid;

    private String gavalue;

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

    public Integer getGaid() {
        return gaid;
    }

    public void setGaid(Integer gaid) {
        this.gaid = gaid;
    }

    public String getGavalue() {
        return gavalue;
    }

    public void setGavalue(String gavalue) {
        this.gavalue = gavalue == null ? null : gavalue.trim();
    }
}
package com.cestc.vspace.pojo;

import java.io.Serializable;

public class Cart implements Serializable {
    private Integer caid;

    private Integer cid;

    private Integer uid;

    private Integer quantity;

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Cart(Integer caid,Integer cid,Integer uid,Integer quantity){
        this.caid=caid;this.cid=cid;
        this.uid=uid;this.quantity=quantity;
    }
}
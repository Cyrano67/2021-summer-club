package com.cestc.vspace.pojo;

import org.apache.solr.client.solrj.beans.Field;
import java.io.Serializable;

public class Clothes implements Serializable {
    @Field("cloth_id")
    private Integer cid;

    @Field("cloth_name")
    private String cname;

    @Field("cloth_price")
    private Integer price;

    @Field("discription")
    private String discription;

    @Field("address")
    private String picAddr;

    @Field("merchant")
    private String merchant;

    @Field("size")
    private String size;

    @Override
    public String toString() {
        return "Cloth{" +
                "cloth_id=" + cid +
                ", cloth_name='" + cname +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription == null ? null : discription.trim();
    }

    public String getPicAddr() {
        return picAddr;
    }

    public void setPicAddr(String picAddr) {
        this.picAddr = picAddr == null ? null : picAddr.trim();
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant == null ? null : merchant.trim();
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Clothes(Integer cid,String cname,Integer price,String discription,String picAddr,String merchant,String size){
        this.cid=cid;this.cname=cname;this.price=price;this.discription=discription;
        this.picAddr=picAddr;this.merchant=merchant;this.size=size;

    }

    public Clothes(){

    }
}
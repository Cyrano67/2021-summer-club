package com.cestc.vspace.pojo;

import java.util.Date;

public class OrdersInfo {
    private Integer oid;

    private Integer orderNo;

    private Integer payment;

    private Integer paymentType;

    private Integer postage;

    private Integer status;

    private Integer shippingId;

    private Date paymentTime;

    private Date sendTime;

    private Date endTime;

    private Date closeTime;

    private Date createTime;

    private Date updateTime;

    private Integer caid;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getPostage() {
        return postage;
    }

    public void setPostage(Integer postage) {
        this.postage = postage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getShippingId() {
        return shippingId;
    }

    public void setShippingId(Integer shippingId) {
        this.shippingId = shippingId;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getCaid() {
        return caid;
    }

    public void setCaid(Integer caid) {
        this.caid = caid;
    }

    public OrdersInfo(Integer oid,Integer orderNo,Integer payment,Integer paymentType,Integer postage,Integer status,Integer shippingId,Date paymentTime,Date sendTime,Date endTime,Date closeTime,Date createTime,Date updateTime,Integer caid){
        //oid,orderNo,payment,paymentType,postage,status,shippingId,paymentTime,sendTime,endTime,closeTime,createTime,updateTime,caid
        this.oid=oid;this.orderNo=orderNo;this.payment=payment;this.paymentType=paymentType;
        this.postage=postage;this.status=status;this.shippingId=shippingId;
        this.paymentTime=paymentTime;this.sendTime=sendTime;
        this.endTime=endTime;this.closeTime=closeTime;
        this.createTime=createTime;this.updateTime=updateTime;
        this.caid=caid;
    }
}
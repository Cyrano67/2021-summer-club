package com.cestc.vspace.pojo;

import java.io.Serializable;

public class PayInfo implements Serializable{
    private Integer pid;

    private Integer payPlatform;

    private String platformNumber;

    private String platformStatus;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getPayPlatform() {
        return payPlatform;
    }

    public void setPayPlatform(Integer payPlatform) {
        this.payPlatform = payPlatform;
    }

    public String getPlatformNumber() {
        return platformNumber;
    }

    public void setPlatformNumber(String platformNumber) {
        this.platformNumber = platformNumber == null ? null : platformNumber.trim();
    }

    public String getPlatformStatus() {
        return platformStatus;
    }

    public void setPlatformStatus(String platformStatus) {
        this.platformStatus = platformStatus == null ? null : platformStatus.trim();
    }
}
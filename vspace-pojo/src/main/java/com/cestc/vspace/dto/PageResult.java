package com.cestc.vspace.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhong
 * @Edition: V1.0
 * CreateDate: 2021/7/15 10:09
 * Description:
 */
public class PageResult implements Serializable {
    //总页数
    private Integer pages;
    //数据集合
    private List dataList;
    //数据总条数
    private Long totalItems;


    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }

    public List getDataList() {
        return dataList;
    }

    public void setDataList(List dataList) {
        this.dataList = dataList;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "pages=" + pages +
                ", dataList=" + dataList +
                ", totalItems=" + totalItems +
                '}';
    }
}

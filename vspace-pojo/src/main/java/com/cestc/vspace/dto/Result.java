package com.cestc.vspace.dto;

import java.io.Serializable;
import java.util.List;

/**
 * @Author: zhong
 * @Edition: V1.0
 * CreateDate: 2021/7/15 10:10
 * Description:
 */
public class Result<E,R> implements Serializable {
    private E entity;
    private R relateOne;
    private List<R> relateMany;

    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public R getRelateOne() {
        return relateOne;
    }

    public void setRelateOne(R relateOne) {
        this.relateOne = relateOne;
    }

    public List<R> getRelateMany() {
        return relateMany;
    }

    public void setRelateMany(List<R> relateMany) {
        this.relateMany = relateMany;
    }
}


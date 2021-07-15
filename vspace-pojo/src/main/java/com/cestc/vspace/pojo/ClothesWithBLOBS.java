package com.cestc.vspace.pojo;

import org.apache.solr.client.solrj.beans.Field;

/**
 * @Author: zhong
 * @Edition: V1.0
 * CreateDate: 2021/7/15 11:10
 * Description:
 */
public class ClothesWithBLOBS extends Clothes {

    @Field("goods_image_url")
    private String imageUrl;


    @Override
    public String toString() {
        return "ClothesWithBLOBS{" +
                " imageUrl='" + imageUrl + '\'' +
                "} " + super.toString();
    }

    public String getImageUrl() {
        return imageUrl;
    }


    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl == null ? null : imageUrl.trim();
    }

}
package com.incubationplatform.entity;

import java.io.Serializable;

/**
 * Created by GMUK on 2018/10/17 0017.
 */
public class TestEntity implements Serializable {
    private String productName;
    private Integer price;
    private Integer sale;
    private String productId;
    private String image;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

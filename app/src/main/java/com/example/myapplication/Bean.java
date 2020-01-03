package com.example.myapplication;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Bean {
    private Long id;
    private String name;
    private String price;
    @Generated(hash = 1800659237)
    public Bean(Long id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    @Generated(hash = 80546095)
    public Bean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPrice() {
        return this.price;
    }
    public void setPrice(String price) {
        this.price = price;
    }
}

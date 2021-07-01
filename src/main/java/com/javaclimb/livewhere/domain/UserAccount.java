package com.javaclimb.livewhere.domain;

import java.io.Serializable;

public class UserAccount implements Serializable {
    private Float money;
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }
}

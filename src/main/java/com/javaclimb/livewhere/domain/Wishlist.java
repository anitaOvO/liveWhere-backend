package com.javaclimb.livewhere.domain;

import java.io.Serializable;

//用户
public class Wishlist implements Serializable {
    private Integer houseId;
    private Integer userId;

    public Integer getHouseId() {
        return houseId;
    }

    public void setHouseId(Integer houseId) {
        this.houseId = houseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

package com.javaclimb.livewhere.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class OrderQuery implements Serializable {
    private int orderId;
    private Timestamp dayStart;
    private Timestamp dayEnd;
    private int userId;
    private int ownerId;
    private int houseId;
    private Float totalPrice;
    private String status;
    private String lable;
    private String houseName;
    private String image1;
    private String addressDetail;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDayStart() {
        return dayStart;
    }

    public void setDayStart(Timestamp dayStart) {
        this.dayStart = dayStart;
    }

    public Timestamp getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(Timestamp dayEnd) {
        this.dayEnd = dayEnd;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getHouseId() {
        return houseId;
    }

    public void setHouseId(int houseId) {
        this.houseId = houseId;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public String getHouseName() {
        return houseName;
    }

    public void setHouseName(String houseName) {
        this.houseName = houseName;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }
}

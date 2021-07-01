package com.javaclimb.livewhere.domain;

import java.io.Serializable;
import java.sql.Timestamp;

public class Account implements Serializable {
    private Integer userId;
    private Float money;
    private String information;
    private String email;
    private String phone;
    private Timestamp time;
    private Float changeMoney;

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

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public Float getChangeMoney() {
        return changeMoney;
    }

    public void setChangeMoney(Float changeMoney) {
        this.changeMoney = changeMoney;
    }
}

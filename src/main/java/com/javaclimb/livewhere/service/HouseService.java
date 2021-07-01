package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.House;

import java.util.List;

//房屋接口

public interface HouseService {
    public boolean insert(House house);//增加
    public boolean update(House house);//修改
    public boolean delete(Integer houseId);//删除
    public List<House> allHouse();//查询所有房子
    public List<House> houseOfCity(String city);//根据城市查询
    public List<House> detailOfHouse(Integer houseId);
    public List<House> houseOfName(String houseName,String city);
    public List<House> landMark(String landmark);//根据地标查询
    public List<House> searchUserHouse(Integer hostId);
}

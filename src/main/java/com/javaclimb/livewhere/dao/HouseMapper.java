package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.House;
import org.springframework.stereotype.Repository;

import java.util.List;

//用户表Dao
@Repository
public interface HouseMapper {
    public int insert(House house);//增加
    public int update(House house);//修改
    public int delete(Integer houseId);//删除
    public List<House> allHouse();//查询所有房子
    public List<House> houseOfCity(String city);//根据城市查询
    public List<House> detailOfHouse(Integer houseId);//根据房屋id查询
    public List<House> houseOfName(String houseName,String city);//根据房屋名模糊查询
    public List<House> landMark(String landmark);//根据地标查询房子

    List<House> searchUserHouse(Integer hostId);
}

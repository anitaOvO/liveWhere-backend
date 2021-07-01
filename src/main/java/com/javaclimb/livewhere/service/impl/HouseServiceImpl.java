package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.HouseMapper;
import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//房屋service实现类
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseMapper houseMapper;
    @Override
    public boolean insert(House house) {
        return houseMapper.insert(house)>0;
    }

    @Override
    public boolean update(House house) {
        return houseMapper.update(house)>0;
    }

    @Override
    public boolean delete(Integer houseId) {
        return houseMapper.delete(houseId)>0;
    }

    @Override
    public List<House> allHouse() {
        return houseMapper.allHouse();
    }

    @Override
    public List<House> detailOfHouse(Integer houseId) {
        return houseMapper.detailOfHouse(houseId);
    }

    @Override
    public List<House> houseOfName(String houseName,String city) {
        return houseMapper.houseOfName(houseName, city);
    }

    @Override
    public List<House> houseOfCity(String city) {
        return houseMapper.houseOfCity(city);
    }

    @Override
    public List<House> landMark(String landmark)
    {
        return houseMapper.landMark(landmark);
    }

    @Override
    public List<House> searchUserHouse(Integer hostId) {
        return houseMapper.searchUserHouse(hostId);
    }
}

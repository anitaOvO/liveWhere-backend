package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.HouseMapper;
import com.javaclimb.livewhere.dao.WishListMapper;
import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.domain.Wishlist;
import com.javaclimb.livewhere.service.HouseService;
import com.javaclimb.livewhere.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//房屋service实现类
@Service
public class WishlistServiceImpl implements WishListService {
    @Autowired
    private WishListMapper wishListMapper;

    @Override
    public boolean insert(Wishlist wishlist) {
        return wishListMapper.insert(wishlist)>0;
    }

    @Override
    public boolean delete(Integer houseId, Integer userId) {
        return wishListMapper.delete(houseId, userId)>0;
    }

    @Override
    public boolean selectExist(Integer houseId, Integer userId) {
        return wishListMapper.selectExist(houseId,userId)==0;
    }
}

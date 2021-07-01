package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.Wishlist;

import java.util.List;

//房屋接口
public interface WishListService {
    public boolean insert(Wishlist wishlist);//增加

    public boolean delete(Integer houseId, Integer userId);//删除
    public boolean selectExist(Integer houseId, Integer userId);//是否已在愿望单中
}

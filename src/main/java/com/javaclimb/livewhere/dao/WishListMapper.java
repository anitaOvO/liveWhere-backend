package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.domain.Wishlist;
import org.springframework.stereotype.Repository;

import java.util.List;

//用户表Dao
@Repository
public interface WishListMapper {
    public int insert(Wishlist wishlist);//增加
    public int delete(Integer houseId, Integer userId);//删除
    public int selectExist(Integer houseId, Integer userId);//是否已在愿望单中
}

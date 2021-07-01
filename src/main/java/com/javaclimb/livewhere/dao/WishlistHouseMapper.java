package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.UserAccount;
import com.javaclimb.livewhere.domain.WishlistHouse;

import java.util.List;

public interface WishlistHouseMapper {
    List<WishlistHouse> selectWishlistHouse(Integer userId);
}

package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.UserAccount;
import com.javaclimb.livewhere.domain.WishlistHouse;

import java.util.List;

public interface WishlistHouseService {
    public List<WishlistHouse> selectWishlistHouse(Integer userId);
}

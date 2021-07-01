package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.WishlistHouseMapper;
import com.javaclimb.livewhere.domain.WishlistHouse;
import com.javaclimb.livewhere.service.WishlistHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishlistHouseServiceImpl implements WishlistHouseService {
    @Autowired
    private WishlistHouseMapper wishlistHouseMapper;

    @Override
    public List<WishlistHouse> selectWishlistHouse(Integer userId) {
        List<WishlistHouse> wishlistHouses = wishlistHouseMapper.selectWishlistHouse(userId);
        return wishlistHouses;
    }
}

package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.dao.WishlistHouseMapper;
import com.javaclimb.livewhere.service.UserAccountService;
import com.javaclimb.livewhere.service.WishlistHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WishlistHouseController {
    @Autowired
    private WishlistHouseService wishlistHouseService;

    //pass
    @RequestMapping(value = "/like")
    public Object loginStatus(@RequestBody JSONObject jsonObject){
        Integer userId = jsonObject.getInteger("userId");
        //Map<String,Object> map=new HashMap<>();
        //List<UserAccount> userAccountList=userAccountService.selectUserAccountList(userId);
        //map.put("userAccountList",userAccountList);
        //return map;
        return wishlistHouseService.selectWishlistHouse(userId);
    }
}

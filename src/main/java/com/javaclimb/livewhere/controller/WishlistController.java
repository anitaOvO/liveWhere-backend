package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.domain.Wishlist;
import com.javaclimb.livewhere.service.HouseService;
import com.javaclimb.livewhere.service.WishListService;
import com.javaclimb.livewhere.utils.Consts;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WishlistController {
    @Autowired
    private WishListService wishListService;

    //初始化房子是否已在心愿单中 pass
    @RequestMapping(value = "/ifInLike",method = RequestMethod.POST)
    public Object ifHouseExist(@RequestBody JSONObject jsonObject) {
        Integer houseId = jsonObject.getInteger("houseId");
        Integer userId = jsonObject.getInteger("userId");
        return !wishListService.selectExist(houseId,userId);
    }

    //添加心愿单 pass
    @RequestMapping(value = "/addLike",method = RequestMethod.POST)
    public Object addHouse(@RequestBody JSONObject jsonObject){

        Integer houseId = jsonObject.getInteger("houseId");
        Integer userId = jsonObject.getInteger("userId");

        Wishlist wishlist = new Wishlist();
        wishlist.setHouseId(houseId);
        wishlist.setUserId(userId);


        JSONObject jsonObject1 = new JSONObject();
        boolean flag2 = wishListService.insert(wishlist);
        if(flag2){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"添加成功");
            return jsonObject1;
        }
        else {
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"数据库出错");
            return jsonObject1;
        }
    }

    //删除心愿单 pass
    @RequestMapping(value = "/deleteWish",method = RequestMethod.POST)
    public Object deleteHouse(@RequestBody JSONObject jsonObject){
        Integer houseId = jsonObject.getInteger("houseId");
        Integer userId = jsonObject.getInteger("userId");

        boolean flag = wishListService.delete(houseId,userId);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"删除成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"删除失败");
            return jsonObject1;
        }
    }

}

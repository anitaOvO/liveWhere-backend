package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.service.HouseService;
import com.javaclimb.livewhere.utils.Consts;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    //添加房屋 pass
    @RequestMapping(value = "/housing",method = RequestMethod.POST)
    public Object addHouse(@RequestBody JSONObject jsonObject){

        Integer hostId = Integer.valueOf(jsonObject.getInteger("hostId"));
        String houseName = jsonObject.getString("houseName").trim();
        Float price = Float.valueOf(jsonObject.getString("price"));
        Float discountPrice = Float.valueOf(jsonObject.getFloat("discountPrice"));
        String area = jsonObject.getString("area").trim();
        String information = jsonObject.getString("information").trim();
        String addressDetail = jsonObject.getString("addressDetail").trim();
        Integer people = Integer.valueOf(jsonObject.getInteger("people"));
        String city = jsonObject.getString("city").trim();
        String lable = jsonObject.getString("lable").trim();
        String toilet = jsonObject.getString("toilet").trim();
        String bed = jsonObject.getString("bed").trim();
        String room = jsonObject.getString("room").trim();
        String image1 = jsonObject.getString("image1").trim();
        String image2 = jsonObject.getString("image1").trim();
        String image3 = jsonObject.getString("image1").trim();

        House house = new House();
        house.setHostId(hostId);
        house.setHouseName(houseName);
        house.setPrice(price);
        house.setDiscountPrice(discountPrice);
        house.setArea(area);
        house.setInformation(information);
        house.setAddressDetail(addressDetail);
        house.setPeople(people);
        house.setStatus(0);
        house.setCity(city);
        house.setLable(lable);
        house.setToilet(toilet);
        house.setBed(bed);
        house.setRoom(room);
        house.setImage1(image1);
        house.setImage2(image2);
        house.setImage3(image3);


        boolean flag = houseService.insert(house);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"添加成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"添加失败");
            return jsonObject1;
        }
    }

    //修改房屋
    @RequestMapping(value = "/updateHouse",method = RequestMethod.POST)
    public Object updateHouse(@RequestBody JSONObject jsonObject){
        Integer houseId = jsonObject.getInteger("houseId");
        String houseName = jsonObject.getString("houseName").trim();
        Float price = jsonObject.getFloat("price");
        Float discountPrice = jsonObject.getFloat("discountPrice");
        String area = jsonObject.getString("area").trim();
        String information = jsonObject.getString("information").trim();
        String addressDetail = jsonObject.getString("addressDetail").trim();
        Integer people = jsonObject.getInteger("people");
        String city = jsonObject.getString("city").trim();
        String lable = jsonObject.getString("lable").trim();
        String toilet = jsonObject.getString("toilet").trim();
        String bed = jsonObject.getString("bed").trim();
        String room = jsonObject.getString("room").trim();
        String image1 = jsonObject.getString("image1").trim();
        String image2 = jsonObject.getString("image2").trim();
        String image3 = jsonObject.getString("image3").trim();


        House house = new House();
        house.setHouseId(houseId);
        house.setHouseName(houseName);
        house.setPrice(price);
        house.setDiscountPrice(discountPrice);
        house.setArea(area);
        house.setInformation(information);
        house.setAddressDetail(addressDetail);
        house.setPeople(people);
        house.setCity(city);
        house.setLable(lable);
        house.setToilet(toilet);
        house.setBed(bed);
        house.setRoom(room);
        house.setImage1(image1);
        house.setImage2(image2);
        house.setImage3(image3);

        boolean flag = houseService.update(house);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"修改成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"修改失败");
            return jsonObject1;
        }
    }

    //删除房屋
    @RequestMapping(value = "/deleteHouse",method = RequestMethod.POST)
    public Object deleteHouse(@RequestBody JSONObject jsonObject){
        Integer houseId = jsonObject.getInteger("houseId");
        boolean flag = houseService.delete(houseId);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"删除成功");
            return jsonObject;
        }
        else{
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"删除失败");
            return jsonObject;
        }
    }

    //所有房屋 pass
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public Object allHouse(){
        return houseService.allHouse();
    }

    //城市名查找 pass
    @RequestMapping(value = "/list")
    public Object houseOfCity(@RequestBody JSONObject jsonObject){
        String city = jsonObject.getString("city").trim();
        List<House> house= houseService.houseOfCity(city);
        JSONArray jsonArray = JSONArray.fromObject(house);
        return jsonArray;
    }

    //房屋名查找 pass
    @RequestMapping(value = "/searchName")
    public Object houseOfName(@RequestBody JSONObject jsonObject){
        String houseName = jsonObject.getString("searchInput").trim();
        String city = jsonObject.getString("city").trim();
        return houseService.houseOfName("%"+houseName+"%",city);
    }

    //房屋详情 pass
    @RequestMapping(value = "/house")
    public Object detailOfHouse(@RequestBody JSONObject jsonObject){
        Integer houseId = jsonObject.getInteger("houseId");
        List<House> house = houseService.detailOfHouse(houseId);
        JSONArray jsonArray = JSONArray.fromObject(house);
        return jsonArray;
    }

    @RequestMapping(value = "/landmark",method = RequestMethod.POST)
    public Object landMark(@RequestBody JSONObject jsonObject)
    {
        String landmark =jsonObject.getString("landmark");

        return houseService.landMark(landmark);
    }
    //房东模式查看发布房源
    @RequestMapping(value = "/searchUserHouse",method = RequestMethod.POST)
    public Object searchUserHouse(@RequestBody JSONObject jsonObject)
    {
        Integer hostId =jsonObject.getInteger("userId");
        return houseService.searchUserHouse(hostId);
    }
}

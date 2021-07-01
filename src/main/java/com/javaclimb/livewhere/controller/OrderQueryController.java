package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.OrderQuery;
import com.javaclimb.livewhere.service.OrderQueryService;
import com.javaclimb.livewhere.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class OrderQueryController {
    @Autowired
    private OrderQueryService orderQueryService;
    /*
     *按状态查询订单
     */
    @RequestMapping(value = "/orderList")
    public Object orderList(@RequestBody JSONObject jsonObject)
    {
        Integer userId = Integer.valueOf(jsonObject.getInteger("userId"));
        String status = jsonObject.getString("status");
        return orderQueryService.orderList(userId,status);
    }

    //根据orderId查找信息 pass
    @RequestMapping(value = "/OrderDetail",method = RequestMethod.POST)
    public Object searchOrder(@RequestBody JSONObject jsonObject)
    {
        Integer orderId = Integer.valueOf(jsonObject.getInteger("orderId"));
        return orderQueryService.searchOrder(orderId);
    }

    //用户插入订单
    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public Object addOrder(@RequestBody JSONObject jsonObject){
        Integer houseId = Integer.valueOf(jsonObject.getInteger("houseId"));
        Integer userId = Integer.valueOf(jsonObject.getInteger("userId"));
        Integer ownerId = Integer.valueOf(jsonObject.getInteger("ownerId"));
        Timestamp dayStart = jsonObject.getTimestamp("dayStart");
        Timestamp dayEnd = jsonObject.getTimestamp("dayEnd");
        Float totalPrice = jsonObject.getFloat("totalPrice");
        String status = jsonObject.getString("status");

        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setHouseId(houseId);
        orderQuery.setUserId(userId);
        orderQuery.setOwnerId(ownerId);
        orderQuery.setDayStart(dayStart);
        orderQuery.setDayEnd(dayEnd);
        orderQuery.setStatus(status);
        orderQuery.setTotalPrice(totalPrice);

        boolean flag = orderQueryService.addOrder(orderQuery);
        if(flag){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"添加成功");
            return jsonObject;
        }
        else{
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"添加失败");
            return jsonObject;
        }
    }

    //查找orderId
    @RequestMapping(value = "/orderId",method = RequestMethod.POST)
    public Object searchOrderId(@RequestBody JSONObject jsonObject)
    {
        Integer userId = Integer.valueOf(jsonObject.getString("userId"));
        Integer houseId = Integer.valueOf(jsonObject.getString("houseId"));
        Timestamp dayStart = jsonObject.getTimestamp("dayStart");
        Timestamp dayEnd = jsonObject.getTimestamp("dayEnd");
        Float totalPrice = Float.valueOf(jsonObject.getInteger("totalPrice"));
        return orderQueryService.searchOrderId(userId,houseId,dayStart,dayEnd,totalPrice);
    }

    //更新订单状态
    @RequestMapping(value = "/changeOrder",method = RequestMethod.POST)
    public Object updateStatus(@RequestBody JSONObject jsonObject)
    {
        Integer orderId = Integer.valueOf(jsonObject.getInteger("orderId"));
        OrderQuery orderQuery = new OrderQuery();
        orderQuery.setOrderId(orderId);
        return orderQueryService.updateStatus(orderQuery);
    }
    //查找订单时间
    @RequestMapping(value = "/searchTime")
    public Object searchTime(@RequestBody JSONObject jsonObject){
        Integer houseId=Integer.valueOf(jsonObject.getInteger("houseId"));
        return orderQueryService.searchTime(houseId);
    }
}

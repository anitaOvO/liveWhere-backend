package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.OrderQuery;

import java.sql.Timestamp;
import java.util.List;

public interface OrderQueryService {
    //按订单状态查询订单
    public List<OrderQuery> orderList(Integer userId,String status);

    public boolean addOrder(OrderQuery orderQuery);//增加

    public  List<OrderQuery> searchOrder(Integer orderId);//查找

    public List<OrderQuery> searchOrderId(Integer userId, Integer houseId, Timestamp dayStart, Timestamp dayEnd, Float totalPrice);

    public boolean updateStatus(OrderQuery orderQuery);

    public List<OrderQuery> searchTime(Integer houseId);
}
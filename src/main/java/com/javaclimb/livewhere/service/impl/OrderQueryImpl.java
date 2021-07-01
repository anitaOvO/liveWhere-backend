package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.OrderQueryMapper;
import com.javaclimb.livewhere.domain.OrderQuery;
import com.javaclimb.livewhere.service.OrderQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
class OrderQueryServiceImpl implements OrderQueryService {
    @Autowired
    private OrderQueryMapper orderQueryMapper;

    @Override
    public List<OrderQuery> orderList(Integer userId, String status) {
        return orderQueryMapper.orderList(userId,status);
    }

    @Override
    public boolean addOrder(OrderQuery orderQuery) {
        return  orderQueryMapper.addOrder(orderQuery)>0;
    }

    @Override
    public List<OrderQuery> searchOrder(Integer orderId) {
        return orderQueryMapper.searchOrder(orderId);
    }

    @Override
    public List<OrderQuery> searchOrderId(Integer userId, Integer houseId, Timestamp dayStart, Timestamp dayEnd, Float totalPrice) {
        return orderQueryMapper.searchOrderId(userId,houseId,dayStart,dayEnd,totalPrice);
    }


    @Override
    public boolean updateStatus(OrderQuery orderQuery) {
        return orderQueryMapper.updateStatus(orderQuery)>0;
    }

    @Override
    public List<OrderQuery> searchTime(Integer houseId) {
        return orderQueryMapper.searchTime(houseId);
    }

}


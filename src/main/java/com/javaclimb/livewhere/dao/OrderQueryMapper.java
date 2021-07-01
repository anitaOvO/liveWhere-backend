package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.OrderQuery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Repository
public interface OrderQueryMapper {
    //查询指定状态的订单
    public List<OrderQuery> orderList(Integer userId,String status);

    //增加订单
    public int addOrder(OrderQuery orderQuery);
    //按id查找订单
    public List<OrderQuery> searchOrder(Integer orderId);
    //查询orderid
    public List<OrderQuery> searchOrderId(Integer userId, Integer houseId, Timestamp dayStart, Timestamp dayEnd, Float totalPrice);
    //查询时间
    public List<OrderQuery> searchTime(Integer houseId);
    //更新状态
    public int updateStatus(OrderQuery orderQuery);

}
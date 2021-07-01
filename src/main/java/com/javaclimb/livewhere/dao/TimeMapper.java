package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.OrderQuery;
import com.javaclimb.livewhere.domain.Time;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;


@Repository
public interface TimeMapper {
    public List<Time> searchTime(Integer houseId);
}
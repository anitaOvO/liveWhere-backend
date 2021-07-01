package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.OrderQueryMapper;
import com.javaclimb.livewhere.dao.TimeMapper;
import com.javaclimb.livewhere.domain.OrderQuery;
import com.javaclimb.livewhere.domain.Time;
import com.javaclimb.livewhere.service.OrderQueryService;
import com.javaclimb.livewhere.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
class TimeServiceImpl implements TimeService {
    @Autowired
    private TimeMapper timeMapper;

    @Override
    public List<Time> searchTime(Integer houseId) {
        return timeMapper.searchTime(houseId);
    }

}


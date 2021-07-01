package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.LandMarkMapper;
import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.domain.LandMark;
import com.javaclimb.livewhere.service.LandMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LandMarkServiceImpl implements LandMarkService {
    @Autowired
    private LandMarkMapper landMarkMapper;

    @Override
    public List<LandMark> ofCity(String city)
    {
        return landMarkMapper.ofCity(city);
    }
}

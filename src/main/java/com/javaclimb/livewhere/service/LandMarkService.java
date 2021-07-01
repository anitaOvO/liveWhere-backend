package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.LandMark;

import java.util.List;

public interface LandMarkService {
    public List<LandMark> ofCity(String city);
}

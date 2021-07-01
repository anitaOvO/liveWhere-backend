package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.Time;

import java.util.List;

public interface TimeService {
    public List<Time> searchTime(Integer houseId);
}
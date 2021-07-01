package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.LandMark;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandMarkMapper {
    public List<LandMark> ofCity(String city);
}

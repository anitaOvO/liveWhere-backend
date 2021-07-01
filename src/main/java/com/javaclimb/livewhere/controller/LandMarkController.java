package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.LandMark;
import com.javaclimb.livewhere.service.LandMarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LandMarkController {
    @Autowired
    private LandMarkService landMarkService;


    @RequestMapping(value = "/ofcity")
    public Object ofCity(@RequestBody JSONObject jsonObject)
    {
        String city =jsonObject.getString("city");
        List<LandMark> landMarks= landMarkService.ofCity(city);
        System.out.println(city);
        return landMarks;
    }
}

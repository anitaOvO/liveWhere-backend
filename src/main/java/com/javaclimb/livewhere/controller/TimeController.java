package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class TimeController {
    @Autowired
    private TimeService timeService;

    @RequestMapping(value = "/disabledTime")
    public Object searchTime(@RequestBody JSONObject jsonObject){
        Integer houseId=Integer.valueOf(jsonObject.getInteger("houseId"));
        return timeService.searchTime(houseId);
    }
}

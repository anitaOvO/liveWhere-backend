package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.Account;
import com.javaclimb.livewhere.domain.Comment;
import com.javaclimb.livewhere.service.AccountService;
import com.javaclimb.livewhere.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/insertAccount",method = RequestMethod.POST)
    public Object insertAccount(@RequestBody JSONObject jsonObject){
        Integer userId = jsonObject.getInteger("userId");
        Float changeMoney = jsonObject.getFloat("changeMoney");
        String information = jsonObject.getString("information");

        Account account = new Account();

        account.setUserId(userId);
        account.setChangeMoney(changeMoney);
        account.setInformation(information);

        boolean flag = accountService.insertAccount(account);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"添加成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"添加失败");
            return jsonObject1;
        }
    }

    @RequestMapping(value = "/selectAccount",method = RequestMethod.POST)
    public Object selectAccount(@RequestBody JSONObject jsonObject){
        Integer userId = jsonObject.getInteger("userId");

        return accountService.selectAccount(userId);
    }
}

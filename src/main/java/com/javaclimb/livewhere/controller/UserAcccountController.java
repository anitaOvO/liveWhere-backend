package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.UserAccount;
import com.javaclimb.livewhere.service.UserAccountService;
import com.javaclimb.livewhere.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserAcccountController {
    @Autowired
    private UserAccountService userAccountService;
    @RequestMapping(value = "/testAccount")
    public Object loginStatus(@RequestBody JSONObject jsonObject){
        Integer userId = jsonObject.getInteger("userId");
        return userAccountService.selectUserAccountList(userId);
    }

    //账号余额
    @RequestMapping(value = "/showMoney",method = RequestMethod.POST)
    public Object Balance(@RequestBody JSONObject jsonObject)
    {
        String userId = jsonObject.getString("userId");
        System.out.println(userId);
        return userAccountService.Balance(Integer.parseInt(userId));
    }

    //充值
    @RequestMapping(value = "/plusMoney",method = RequestMethod.POST)
    public Object AddMoney(@RequestBody JSONObject jsonObject)
    {
        String  userId = jsonObject.getString("userId");
        Float money1 = jsonObject.getFloat("money");

        UserAccount money2 =  userAccountService.Balance(Integer.parseInt(userId));
        Float money3 = money2.getMoney();
        Float  money = money1+money3;

        UserAccount userAccount = new UserAccount();
        userAccount.setMoney(money);
        userAccount.setUserId(Integer.parseInt(userId));

        boolean flag = userAccountService.AddMoney(userAccount);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"充值成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"充值失败");
            return jsonObject1;
        }

    }

    //提现 error
    @RequestMapping(value = "/downMoney",method = RequestMethod.POST)
    public Object WithDraw(@RequestBody JSONObject jsonObject)
    {
        String  userId = jsonObject.getString("userId");
        Float money1 = jsonObject.getFloat("money");

        UserAccount money2 =  userAccountService.Balance(Integer.parseInt(userId));
        Float money3 = money2.getMoney();
        Float  money = money3 -money1;

        UserAccount userAccount = new UserAccount();
        userAccount.setMoney(money);
        userAccount.setUserId(Integer.parseInt(userId));

        boolean flag = userAccountService.WithDraw(userAccount);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"提现成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"提现失败");
            return jsonObject1;
        }

    }

    //提现or花费
    @RequestMapping(value = "/spend",method = RequestMethod.POST)
    public Object Spend(@RequestBody JSONObject jsonObject)
    {
        String  userId = jsonObject.getString("userId");
        Float money1 = jsonObject.getFloat("money");

        UserAccount money2 =  userAccountService.Balance(Integer.parseInt(userId));
        Float money3 = money2.getMoney();
        Float  money = money3 - money1;

        JSONObject jsonObject1 = new JSONObject();
        if(money>=0){
            UserAccount userAccount = new UserAccount();
            userAccount.setMoney(money);
            userAccount.setUserId(Integer.parseInt(userId));

            boolean flag = userAccountService.Spend(userAccount);

            if(flag){
                jsonObject1.put(Consts.CODE,1);
                jsonObject1.put(Consts.MSG,"成功");
                return jsonObject1;
            }
            else{
                jsonObject1.put(Consts.CODE,0);
                jsonObject1.put(Consts.MSG,"失败");
                return jsonObject1;
            }
        }
        else {
            jsonObject1.put(Consts.CODE,2);
            jsonObject1.put(Consts.MSG,"钱不够");
            return jsonObject1;
        }
    }
}

package com.javaclimb.livewhere.service.impl;


import com.javaclimb.livewhere.dao.UserAccountMapper;
import com.javaclimb.livewhere.domain.UserAccount;
import com.javaclimb.livewhere.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountMapper userAccountMapper;


    @Override
    public List<UserAccount> selectUserAccountList(Integer userId) {
        List<UserAccount> userAccounts = userAccountMapper.selectUserAccountList(userId);
        return userAccounts;
    }
    /*
    *账户余额
     */
    @Override
    public UserAccount Balance(Integer userId)
    {
        return userAccountMapper.Balance(userId);
    }
    /*
    *钱包充值
     */
    @Override
    public boolean AddMoney(UserAccount userAccount)
    {
        return userAccountMapper.AddMoney(userAccount)>0;
    }
    /*
     *钱提现
     */
    @Override
    public boolean WithDraw(UserAccount userAccount)
    {
        return userAccountMapper.WithDraw(userAccount)>0;
    }
    /*
     *预定民宿花费
     */
    @Override
    public boolean Spend(UserAccount userAccount)
    {
        return userAccountMapper.Spend(userAccount)>0;
    }
}

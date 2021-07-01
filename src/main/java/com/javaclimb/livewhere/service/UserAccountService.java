package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.UserAccount;

import java.util.List;

public interface UserAccountService {
    public List<UserAccount> selectUserAccountList(Integer userId);
    public UserAccount Balance(Integer userId);
    /*
    *钱包充值
     */
    public boolean AddMoney(UserAccount userAccount);
    /*
     *钱提现
     */
    public boolean WithDraw(UserAccount userAccount);
    /*
     *预定民宿花费
     */
    public boolean Spend(UserAccount userAccount);
}

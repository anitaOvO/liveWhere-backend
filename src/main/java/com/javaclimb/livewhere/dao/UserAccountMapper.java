package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.domain.UserAccount;

import java.util.List;

public interface UserAccountMapper {
    List<UserAccount> selectUserAccountList(Integer userId);
    /*
    *账户余额
     */
    public UserAccount Balance(Integer userId);
    /*
    *钱包充值
     */
    public int AddMoney(UserAccount userAccount);
    /*
    *钱提现
     */
    public int WithDraw(UserAccount userAccount);
    /*
    *预定民宿花费
     */
    public int Spend(UserAccount userAccount);

}

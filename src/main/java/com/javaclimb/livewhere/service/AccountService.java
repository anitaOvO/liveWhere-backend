package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.Account;

import java.util.List;

public interface AccountService {
    public boolean insertAccount(Account account);
    public  List<Account> selectAccount(Integer userId);//查询
}

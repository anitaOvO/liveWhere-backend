package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.AccountMapper;
import com.javaclimb.livewhere.domain.Account;
import com.javaclimb.livewhere.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountMapper accountMapper;

    @Override
    public boolean insertAccount(Account account)
    {
        return accountMapper.insertAccount(account)>0;
    }

    @Override
    public List<Account> selectAccount(Integer userId)
    {
        return accountMapper.selectAccount(userId);
    }
}

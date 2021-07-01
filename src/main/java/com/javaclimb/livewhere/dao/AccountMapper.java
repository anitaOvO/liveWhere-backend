package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.Account;
import com.javaclimb.livewhere.domain.House;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {

    public int insertAccount(Account account);//添加

    List<Account> selectAccount(Integer userId);//查询

}


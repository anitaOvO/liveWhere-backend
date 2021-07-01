package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.UserMapper;
import com.javaclimb.livewhere.domain.User;
import com.javaclimb.livewhere.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//用户service实现类
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean verifyPassword(String userName, String password,Integer flag) {
        if(userMapper.verifyPassword(userName,password,flag)>0)
            return true;
        else
            return false;
    }

    @Override
    public int verifyUser(String userName) {
        if(userMapper.verifyUser(userName)>0)
            return 1;
        else
            return 0;
    }
    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user)>0;
    }

    @Override
    public List<User> searchUserInfo(String userName) {
        return userMapper.searchUserInfo(userName);
    }

    @Override
    public boolean deleteUser(Integer userId) {
        return  userMapper.deleteUser(userId)>0;
    }

    @Override
    public List<User> searchUser(Integer userId) {
        return userMapper.searchUser(userId);
    }

    @Override
    public boolean updateUser(User user) {
        return userMapper.updateUser(user)>0;
    }

    @Override
    public boolean updateUserEmail(User user) {
        return userMapper.updateUserEmail(user)>0;
    }

    @Override
    public boolean updatePassword(User user) {
        return userMapper.updatePassword(user)>0;
    }
}

package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.User;

import java.util.List;

//用户接口
public interface UserService {
    public boolean verifyPassword(String userName, String password,Integer flag);
    public int verifyUser(String userName);
    public boolean addUser(User user);
    public List<User> searchUserInfo(String userName);
    public boolean deleteUser(Integer userId);
    public List<User> searchUser(Integer userId);
    public boolean updateUser(User user);
    public boolean updateUserEmail(User user);
    public boolean updatePassword(User user);
}

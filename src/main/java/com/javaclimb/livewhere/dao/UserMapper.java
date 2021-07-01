package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//用户表Dao
@Repository
public interface UserMapper {
    //验证用户名密码,返回数字
    public int verifyPassword(String userName, String password,Integer flag);
    //验证用户名
    public int verifyUser(String userName);
    //添加用户
    public int addUser(User user);
    //返回userId
    public List<User> searchUserInfo(String userName);
    //注销用户
    public int deleteUser(Integer userId);
    //返回用户信息
    public List<User> searchUser(Integer userId);
    //更新用户电话
    public int updateUser(User user);
    //修改邮箱
    public int updateUserEmail(User user);
    //更改密码
    public int updatePassword(User user);
}

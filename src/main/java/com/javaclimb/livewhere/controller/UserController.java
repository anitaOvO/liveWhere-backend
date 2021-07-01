package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.domain.User;
import com.javaclimb.livewhere.service.UserService;
import com.javaclimb.livewhere.utils.Consts;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    //登陆 pass
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object loginStatus(@RequestBody JSONObject jsonObject){
        String userName = jsonObject.getString("userName");
        String password = jsonObject.getString("password");
        Integer flagL = Integer.valueOf(jsonObject.getString("flag"));
        boolean flag = userService.verifyPassword(userName,password,flagL);
        if(flag){
            List<User> user= userService.searchUserInfo(userName);
            JSONArray jsonArray = JSONArray.fromObject(user);
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.userTrueName,userName);
            jsonArray.add(jsonObject1);
            return jsonArray;
        }
        else{
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,userName);
            JSONArray jsonArray = JSONArray.fromObject(jsonObject);
            jsonArray.add(jsonObject1);
            return jsonArray;
        }
    }

    //注册 pass
    @RequestMapping(value = "/register",method = RequestMethod.POST)//HttpServletRequest request
    public Object addUser(@RequestBody JSONObject jsonObject){
        String userName = jsonObject.getString("userName");
        String password = jsonObject.getString("password");
        Integer flag = jsonObject.getInteger("flag");
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setFlag(flag);
        boolean flag1 = userService.verifyUser(userName)>0;
        if(flag1){
            jsonObject.put(Consts.CODE,0);
            jsonObject.put(Consts.MSG,"用户名已存在");
            return jsonObject;
        }
        boolean flag2 = userService.addUser(user);
        if(flag2){
            jsonObject.put(Consts.CODE,1);
            jsonObject.put(Consts.MSG,"插入成功");
            return jsonObject;
        }
        else {
            jsonObject.put(Consts.CODE,2);
            jsonObject.put(Consts.MSG,"插入失败");
            return jsonObject;
        }
    }

    //注销
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST)
    public Object deleteUser(@RequestBody JSONObject jsonObject){
        Integer userId = jsonObject.getInteger("userId");
        boolean flag = userService.deleteUser(userId);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"删除成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"删除失败");
            return jsonObject1;
        }
    }

    //用户信息 pass
    @RequestMapping(value = "/showPhone")
    public Object searchUser(@RequestBody JSONObject jsonObject){
        Integer userId = jsonObject.getInteger("userId");
        List<User> users= userService.searchUser(userId);
        JSONArray jsonArray = JSONArray.fromObject(users);
        return jsonArray;
    }

    //修改电话 pass
    @RequestMapping(value = "/updatePhone",method = RequestMethod.POST)
    public Object updateUser(@RequestBody JSONObject jsonObject){
        Integer userId=jsonObject.getInteger("userId");
        String phone = jsonObject.getString("phone");

        User user = new User();
        user.setUserId(userId);
        user.setPhone(phone);

        boolean flag = userService.updateUser(user);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"修改成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"修改失败");
            return jsonObject1;
        }
    }

    //修改邮箱 pass
    @RequestMapping(value = "/updateEmail",method = RequestMethod.POST)
    public Object updateUserEmail(@RequestBody JSONObject jsonObject){
        Integer userId=jsonObject.getInteger("userId");
        String email = jsonObject.getString("email");

        User user = new User();
        user.setUserId(userId);
        user.setEmail(email);

        boolean flag = userService.updateUserEmail(user);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"修改成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"修改失败");
            return jsonObject1;
        }
    }

    //修改密码 pass
    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public Object updateUserPassword(@RequestBody JSONObject jsonObject){
        Integer userId=jsonObject.getInteger("userId");
        String userName = jsonObject.getString("userName");
        String oldPassword = jsonObject.getString("oldPassword");
        String newPassword = jsonObject.getString("newPassword").trim();
        Integer flagL=Integer.valueOf(jsonObject.getString("flag"));


        User user = new User();
        user.setUserId(userId);
        user.setUserName(userName);
        user.setPassword(newPassword);

        boolean flag = userService.verifyPassword(userName,oldPassword,flagL);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            boolean flag2 = userService.updatePassword(user);
            if (flag2){
                jsonObject1.put(Consts.CODE,1);
                jsonObject1.put(Consts.MSG,"修改成功");
            }
            else {
                jsonObject1.put(Consts.CODE,0);
                jsonObject1.put(Consts.MSG,"修改失败");
            }
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,2);
            jsonObject1.put(Consts.MSG,"旧密码不一致");
            return jsonObject1;
        }
    }
}

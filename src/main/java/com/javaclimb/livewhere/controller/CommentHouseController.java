package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.Comment;
import com.javaclimb.livewhere.domain.CommentHouse;
import com.javaclimb.livewhere.service.CommentHouseService;
import com.javaclimb.livewhere.service.CommentService;
import com.javaclimb.livewhere.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class CommentHouseController {
    @Autowired
    private CommentHouseService commentService;

    //查询用户的所有评论以及评论房屋的信息
    @RequestMapping(value = "/selectUserComment")
    public Object selectUserComment(@RequestBody JSONObject jsonObject){
        Integer hostId = jsonObject.getInteger("userId");
        return commentService.commentOfUser(hostId);
    }
    //查询用户的所有评论以及评论房屋的信息
    @RequestMapping(value = "/selectUserComment2")
    public Object selectUserComment2(@RequestBody JSONObject jsonObject){
        Integer userId = jsonObject.getInteger("userId");
        return commentService.userComment(userId);
    }
}

package com.javaclimb.livewhere.controller;

import com.alibaba.fastjson.JSONObject;
import com.javaclimb.livewhere.domain.Comment;
import com.javaclimb.livewhere.service.CommentService;
import com.javaclimb.livewhere.utils.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    //查找评论 pass
    @RequestMapping(value = "/selectComment",method = RequestMethod.POST)
    public Object selectComment(@RequestBody JSONObject jsonObject){
        Integer houseId = jsonObject.getInteger("houseId");
        return commentService.selectComment(houseId);
    }

    @RequestMapping(value = "/insertComment",method = RequestMethod.POST)
    public Object insertComment(@RequestBody JSONObject jsonObject){
        String detail = jsonObject.getString("detail");
        Integer orderId = jsonObject.getInteger("orderId");
        Integer userId = jsonObject.getInteger("userId");
        Integer houseId = jsonObject.getInteger("houseId");

        Comment comment = new Comment();

        comment.setDetail(detail);
        comment.setOrderId(orderId);
        comment.setUserId(userId);
        comment.setHouseId(houseId);

        boolean flag = commentService.insertComment(comment);
        JSONObject jsonObject1 = new JSONObject();
        if(flag){
            jsonObject1.put(Consts.CODE,1);
            jsonObject1.put(Consts.MSG,"添加成功");
            return jsonObject1;
        }
        else{
            jsonObject1.put(Consts.CODE,0);
            jsonObject1.put(Consts.MSG,"添加失败");
            return jsonObject1;
        }
    }

    @RequestMapping(value = "/updateComment",method = RequestMethod.POST)
    public Object updateComment(@RequestBody JSONObject jsonObject){
        String detail = jsonObject.getString("detail");
        Integer userId = jsonObject.getInteger("userId");
        Integer houseId = jsonObject.getInteger("houseId");
        Timestamp time = jsonObject.getTimestamp("time");
        Integer orderId = jsonObject.getInteger("orderId");

        Comment comment = new Comment();

        comment.setDetail(detail);
        comment.setTime(time);

        boolean flag = commentService.updateComment(detail,houseId,userId,time,orderId);
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

    @RequestMapping(value = "/deleteComment",method = RequestMethod.POST)
    public Object deleteComment(@RequestBody JSONObject jsonObject) {
        Integer houseId = jsonObject.getInteger("houseId");
        Integer userId = jsonObject.getInteger("userId");
        String detail = jsonObject.getString("detail");

        boolean flag = commentService.deleteComment(houseId, userId, detail);
        JSONObject jsonObject1 = new JSONObject();
        if (flag) {
            jsonObject1.put(Consts.CODE, 1);
            jsonObject1.put(Consts.MSG, "删除成功");
            return jsonObject1;
        } else {
            jsonObject1.put(Consts.CODE, 0);
            jsonObject1.put(Consts.MSG, "删除失败");
            return jsonObject1;
        }
    }

}

package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.Comment;
import java.sql.Timestamp;
import java.util.List;

public interface CommentService {
    public List<Comment> selectComment(Integer houseId);
    public boolean insertComment(Comment comment);//增加评论
    public boolean updateComment(String detail, Integer houseId, Integer userId, Timestamp time,Integer orderId);//修改评论
    public boolean deleteComment(Integer houseId, Integer userId, String detail);//删除评论
}

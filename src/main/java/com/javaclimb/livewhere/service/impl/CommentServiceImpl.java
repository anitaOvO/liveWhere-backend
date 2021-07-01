package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.CommentMapper;
import com.javaclimb.livewhere.domain.Comment;
import com.javaclimb.livewhere.domain.House;
import com.javaclimb.livewhere.domain.WishlistHouse;
import com.javaclimb.livewhere.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public List<Comment> selectComment(Integer houseId) {
        return  commentMapper.selectComment(houseId);
    }

    @Override
    public boolean insertComment(Comment comment) {
        return commentMapper.insertComment(comment)>0;
    }

    @Override
    public boolean updateComment(String detail, Integer houseId, Integer userId, Timestamp time,Integer orderId)
    {
        return commentMapper.updateComment(detail,houseId,userId,time,orderId)>0;
    }

    @Override
    public boolean deleteComment( Integer houseId, Integer userId,String detail)
    {
        return commentMapper.deleteComment(houseId,userId,detail)>0;
    }
}

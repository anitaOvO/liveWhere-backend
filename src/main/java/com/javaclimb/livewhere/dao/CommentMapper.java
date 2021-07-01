package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.Comment;
import com.javaclimb.livewhere.domain.WishlistHouse;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CommentMapper {
    /*
    *查询评论
     */
    List<Comment> selectComment(Integer houseId);
    /*
    *添加评论
     */
    public int insertComment(Comment comment);
    /*
    *修改评论
     */
    public int updateComment(String detail, Integer houseId, Integer userId, Timestamp time ,Integer orderId);
    /*
    *删除评论
     */
    public int deleteComment(Integer houseId, Integer userId, String detail);
}

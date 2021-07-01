package com.javaclimb.livewhere.service.impl;

import com.javaclimb.livewhere.dao.CommentHouseMapper;
import com.javaclimb.livewhere.dao.CommentMapper;
import com.javaclimb.livewhere.domain.Comment;
import com.javaclimb.livewhere.domain.CommentHouse;
import com.javaclimb.livewhere.service.CommentHouseService;
import com.javaclimb.livewhere.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CommentHouseServiceImpl implements CommentHouseService {
    @Autowired
    private CommentHouseMapper commentHouseMapper;

    @Override
    public List<CommentHouse> commentOfUser(Integer hostId) {
        return commentHouseMapper.commentOfUser(hostId);
    }

    @Override
    public List<CommentHouse> userComment(Integer userId) {
        return commentHouseMapper.userComment(userId);
    }
}

package com.javaclimb.livewhere.service;

import com.javaclimb.livewhere.domain.CommentHouse;

import java.util.List;

public interface CommentHouseService {
    public List<CommentHouse> commentOfUser(Integer hostId);
    public List<CommentHouse> userComment(Integer userId);
}

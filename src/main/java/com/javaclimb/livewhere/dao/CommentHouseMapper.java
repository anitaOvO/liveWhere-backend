package com.javaclimb.livewhere.dao;

import com.javaclimb.livewhere.domain.CommentHouse;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CommentHouseMapper {
    public List<CommentHouse> commentOfUser(Integer hostId);
    public List<CommentHouse> userComment(Integer userId);
}

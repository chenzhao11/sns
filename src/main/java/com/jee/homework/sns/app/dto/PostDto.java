package com.jee.homework.sns.app.dto;

import com.jee.homework.sns.app.model.Comment;
import com.jee.homework.sns.app.model.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class PostDto {
    private Long id;
    private Date createTime;
    private Date updateTiem;
    public UserDto user;
    public Integer commentCount;
    public String content;
    private List<CommentDto> comments = new ArrayList<>();
}

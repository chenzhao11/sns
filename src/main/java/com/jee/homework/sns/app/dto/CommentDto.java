package com.jee.homework.sns.app.dto;


import com.jee.homework.sns.app.model.Post;
import com.jee.homework.sns.app.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class CommentDto {
    private Long id;
    private Date createTime;
    private Date updateTiem;
    private PostDto post;
    private UserDto user;
    private String content;

}

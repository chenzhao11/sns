package com.jee.homework.sns.app.dto;


import com.jee.homework.sns.app.model.Post;
import com.jee.homework.sns.app.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class CommentDto {
    private Long id;
    private Date createTime;
    private Date updateTiem;
    private Long postId;
    private Long userId;
    private String content;

}

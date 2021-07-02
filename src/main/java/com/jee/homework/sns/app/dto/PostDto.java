package com.jee.homework.sns.app.dto;

import com.jee.homework.sns.app.model.Comment;
import com.jee.homework.sns.app.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
public class PostDto {
    private Long id;
    private Date createTime;
    private Date updateTiem;
    public Long userId;
    public Integer commentCount;
    public String content;
    private List<CommentDto> comments = new ArrayList<>();
}

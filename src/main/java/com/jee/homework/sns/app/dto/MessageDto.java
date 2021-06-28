package com.jee.homework.sns.app.dto;

import com.jee.homework.sns.app.model.User;
import lombok.Data;

import java.util.Date;

@Data
public class MessageDto {
    private Long id;
    private Date createTime;
    private Date updateTiem;
    public UserDto fromUser;
    public UserDto toUser;
    public String content;
}

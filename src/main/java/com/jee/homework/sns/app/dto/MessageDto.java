package com.jee.homework.sns.app.dto;

import com.jee.homework.sns.app.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter
@Setter
public class MessageDto {
    private Long id;
    private Date createTime;
    private Date updateTiem;
    public Long fromUserId;
    public Long toUserId;
    public String content;
}

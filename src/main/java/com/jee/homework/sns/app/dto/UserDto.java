package com.jee.homework.sns.app.dto;

import com.jee.homework.sns.app.model.Comment;
import com.jee.homework.sns.app.model.Post;
import com.jee.homework.sns.app.model.Role;
import com.jee.homework.sns.app.model.Status;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class UserDto {
    private Long id;
    private Date createTime;
    private Date updateTiem;
    private List<RoleDto> roles = new ArrayList<>();
    private StatusDto status;
    private String headPicUrl;
    @NotNull(message = "用户名不能为空")
    private String name;
    @NotNull(message = "用户密码不能为空")
    private String password;
    private String nickname;
    private List<PostDto> likePosts = new ArrayList<>();
    private List<CommentDto> comments = new ArrayList<>();
    private List<PostDto> posts = new ArrayList<>();
    public void addRole(RoleDto roleDto){
        this.roles.add(roleDto);
    }
    public List<String> getRoleNames(){
        List<String> roleNames = new ArrayList<>();
        for(RoleDto roleDto : roles ){
            roleNames.add(roleDto.getRoleName());
        }
        return roleNames;
    }

}

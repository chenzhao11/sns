package com.jee.homework.sns;

import com.jee.homework.sns.app.dto.RoleDto;
import com.jee.homework.sns.app.dto.StatusDto;
import com.jee.homework.sns.app.dto.UserDto;
import com.jee.homework.sns.app.service.UserService;
import com.jee.homework.sns.common.constant.RoleConstants;
import com.jee.homework.sns.common.constant.StatusConstants;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Slf4j
@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;

    @Test
    void testAddUser() {
        UserDto userDto=new UserDto();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.setName("chen");
        userDto.setPassword(encoder.encode("123456"));
        userDto.addRole(new RoleDto(RoleConstants.ROLE_USER_ID));
        StatusDto statusDto = new StatusDto(StatusConstants.ENABLE_ID);
        userDto.setStatus(statusDto);
        userService.addUser(userDto);
    }
    @Test
    void testAddStatus(){
        StatusDto enableStatusDto = new StatusDto(StatusConstants.ENABLE_ID);
        StatusDto disableStatusDto =  new StatusDto(StatusConstants.DISABLE_ID);
        userService.addStatus(enableStatusDto);
        userService.addStatus(disableStatusDto);
    }
    @Test
    void testDeleteUser(){
        userService.deleteUser(2L);
    }

    @Test
    void testAddRole(){
        RoleDto user_roleDto = new RoleDto(RoleConstants.ROLE_USER_ID);
        RoleDto admin_roleDto = new RoleDto(RoleConstants.ROLE_ADMIN_ID);
        userService.addRole(user_roleDto);
//        userService.addRole(admin_roleDto);

    }


}

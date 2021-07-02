package com.jee.homework.sns;

import com.jee.homework.sns.app.dto.RoleDto;
import com.jee.homework.sns.app.dto.StatusDto;
import com.jee.homework.sns.app.dto.UserDto;
import com.jee.homework.sns.app.model.Status;
import com.jee.homework.sns.app.model.User;
import com.jee.homework.sns.app.repository.UserRepository;
import com.jee.homework.sns.app.service.UserService;
import com.jee.homework.sns.common.constant.RoleConstants;
import com.jee.homework.sns.common.constant.StatusConstants;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
public class UserServiceTest {
    @Resource
    private UserService userService;
    @Resource
    private UserRepository userRepository;

    @Test
    void testAddUser() {
        UserDto userDto=new UserDto();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        userDto.setName("chen");
        userDto.setPassword(encoder.encode("123456"));
        userDto.addRole(new RoleDto(RoleConstants.ROLE_USER_ID));
        userDto.setStatusId(StatusConstants.ENABLE_ID);
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
    @Test
    void testGetUserRoles(){
        int id = 1;
        List<UserDto> userDtos = userService.getUserByUsername("chen");
        UserDto test = userDtos.get(0);
        List<String> roleNames = test.getRoleNames();
        System.out.println(roleNames.toString());

    }
    @Test
    void testUpdateUserStatus(){
        User user = userRepository.getById(1L);
        Status status = new Status();
        status.setId(2L);
        user.setStatus(status);
        userRepository.save(user);

    }


}

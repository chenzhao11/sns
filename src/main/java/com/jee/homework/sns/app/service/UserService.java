package com.jee.homework.sns.app.service;

import com.jee.homework.sns.app.dto.RoleDto;
import com.jee.homework.sns.app.dto.StatusDto;
import com.jee.homework.sns.app.dto.UserDto;
import com.jee.homework.sns.app.model.Role;
import com.jee.homework.sns.app.model.Status;
import com.jee.homework.sns.app.model.User;
import com.jee.homework.sns.app.repository.RoleRepository;
import com.jee.homework.sns.app.repository.StatusRepository;
import com.jee.homework.sns.app.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private StatusRepository statusRepository;
    /**
     * 新增用户
     * @Return 新增用户的ID
     */
    public Long addUser(UserDto userDto){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        User user=new User();
        //把UserDTO对象转换成User对象
        BeanUtils.copyProperties(userDto,user);
        //把roles列表中的RoleDTO类型转换成Role类型
        List<Role> roles = new ArrayList<>();
        for(RoleDto roleDto : userDto.getRoles()){
            Role role = new Role();
            BeanUtils.copyProperties(roleDto,role);
            roles.add(role);
        }
        user.setRoles(roles);
        //把StatusDTO转换成Status类型
        Status status = new Status();
        BeanUtils.copyProperties(userDto.getStatus(),status);
        user.setStatus(status);
        return userRepository.save(user).getId();
    }
    /**
     * 新建角色
     */
    public Long addRole(RoleDto roleDto){
        Role role=new Role();
        BeanUtils.copyProperties(roleDto,role);
        return roleRepository.save(role).getId();
    }
    /**
     * 删除用户
     * @param  Id 要删除用户的ID
     */
    public void deleteUser(Long Id){
        userRepository.deleteById(Id);

    }
    /**
     * 添加用户状态
     * @Param status_id  状态的ID
     */
    public void addStatus(StatusDto statusDto){
        Status status =new Status();
        BeanUtils.copyProperties(statusDto,status);
        log.warn("userservice中：");
        log.warn(status.toString());
        log.warn("原来的是：");
        log.warn(statusDto.toString());
        statusRepository.save(status);
    }
    /**
     * 根据用户名查找用户
     */
    public List<UserDto> getUserByUsername(String username){
        List<User> users = userRepository.findByName(username);
        //把User转换成UserDto
        List<UserDto> userDtos = new ArrayList<>();
        for(User user: users){
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(user,userDto);
            //把roles列表中的Role类型转换成RoleDto类型
            for(Role role : user.getRoles()){
                RoleDto roleDto = new RoleDto();
                BeanUtils.copyProperties(role,roleDto);
                userDto.getRoles().add(roleDto);
            }
            //Status转换成StatusDto
            StatusDto statusDto = new StatusDto();
            BeanUtils.copyProperties(user.getStatus(),statusDto);
            userDto.setStatus(statusDto);
            userDtos.add(userDto);
        }
        return  userDtos;

    }

}

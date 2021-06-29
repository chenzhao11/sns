package com.jee.homework.sns.app.controller;

import com.jee.homework.sns.app.service.AuthService;
import com.jee.homework.sns.app.vo.UserLoginVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AuthController {
    @Autowired
    private AuthService authService;
    @RequestMapping(path ="/auth",method = RequestMethod.POST)
    public String login(@RequestBody UserLoginVo userLoginVo) throws AuthenticationException {
        final String token = authService.login(userLoginVo.getName(),userLoginVo.getPassword());
        return token;
    }
}

package com.haichao.controller;

import com.haichao.service.IUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @Desc </p>
 * @Author yusj
 * @Date 2019/3/11
 * @Version 1.0
 */
@RestController
public class UserController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @Resource
    private IUserService iUserService;


    @RequestMapping("/login")
    public String login(String username,String passwd) {
        boolean login = iUserService.login(username, passwd);
        if(login) {
            return "登陆成功";
        }else {
            return  "登陆失败";
        }
    }

    @RequestMapping("/register")
    public String register(String username,String passwd) {
        boolean login = iUserService.register(username, passwd);
        if(login) {
            return "注册成功";
        }else {
            return  "注册失败";
        }
    }

    @RequestMapping("/batchAdd")
    public String batchAdd(String username,String passwd) {
        iUserService.batchAdd(username, passwd);
        return "成功";
    }
}
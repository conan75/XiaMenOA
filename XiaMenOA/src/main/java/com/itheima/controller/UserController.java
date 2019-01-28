package com.itheima.controller;

import com.itheima.domain.TbUser;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/checkLogin.do")
    public String checkLogin(String username,String password){
        TbUser user=userService.checkLogin(username,password);
        if (user==null){
            //验证失败
            return "";
        }
        //验证成功
        return "departmentPage";
    }

}

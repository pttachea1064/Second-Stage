package cn.tedu.controller;

import cn.tedu.service.UserService;
import cn.tedu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    public void save() {
        userService.save();
    }
}


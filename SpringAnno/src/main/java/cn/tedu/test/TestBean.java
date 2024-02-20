package cn.tedu.test;


import cn.tedu.controller.UserController;
import cn.tedu.service.impl.UserServiceImpl;

public class TestBean {
    private static UserController controller;

    public static void main(String[] args) {
        controller = new UserController();
        controller.save();
    }
}

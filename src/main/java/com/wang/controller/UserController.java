package com.wang.controller;

import com.wang.mapper.UserMapper;
import com.wang.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by wangzhiming on 2022/6/5 11:16
 */
@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/queryUserList")
    public List<User> queryUserList() {
        List<User> userList = userMapper.queryUserList();

        for (User user : userList) {
            System.out.println(user);
        }

        return userList;
    }

    //添加一个用户
    @GetMapping("/addUser")
    public String addUser() {
        userMapper.addUser(new User(7,"阿毛","123456"));
        return "ok";
    }

    //修改一个用户
    @GetMapping("/updateUser")
    public String updateUser() {
        userMapper.updateUser(new User(7,"阿毛","123456"));
        return "ok";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(7);

        return "ok";
    }
}

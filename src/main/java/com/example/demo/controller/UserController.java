package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.ResultInfoDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResultInfoDTO<Object> creteUser(@RequestBody User user) {
        ResultInfoDTO<Object> response = new ResultInfoDTO<Object>();
        int result = userService.createUser(user);
        response.setCode(ResultInfoDTO.OK);
        response.setMessage("创建用户成功！");
        response.setData(result);
        return response;
    }

    @GetMapping("/{id}")
    public ResultInfoDTO<Object> selectByPrimaryKey(@PathVariable("id") int id) {
        ResultInfoDTO<Object> response = new ResultInfoDTO<Object>();
        User user = userService.selectByPrimaryKey(id);
        response.setCode(ResultInfoDTO.OK);
        response.setMessage("查询用户成功！");
        response.setData(user);
        return response;
    }

}
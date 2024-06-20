package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bo.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ApiResponse<Object>> creteUser(@RequestBody User user) {
        int result = userService.createUser(user);
        return createSuccessResponse(result);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Object>> selectByPrimaryKey(@PathVariable("id") int id) {
        User user = userService.selectByPrimaryKey(id);
        return createSuccessResponse(user);
    }

}
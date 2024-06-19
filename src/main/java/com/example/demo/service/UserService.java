package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
  int createUser(User user);

  User selectByPrimaryKey(int userId);

}

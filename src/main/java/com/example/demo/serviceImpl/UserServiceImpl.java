package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Override
  @Transactional
  public int createUser(User user) {
    return userMapper.insert(user);
  }

  @Override
  public User selectByPrimaryKey(int id) {
    return userMapper.selectByPrimaryKey(id);
  }
}

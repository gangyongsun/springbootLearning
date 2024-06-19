package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private RoleService roleService;

  @Override
  @Transactional
  public int createUser(User user) {
    userMapper.insert(user);

    Role role = new Role();
    role.setRoleId("10002");
    role.setRoleName("user");
    roleService.createRole(role);
    // int a = 1 / 0;
    return 1;
  }

  @Override
  public User selectByPrimaryKey(int id) {
    return userMapper.selectByPrimaryKey(id);
  }
}

package com.example.demo.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.RoleMapper;
import com.example.demo.entity.Role;
import com.example.demo.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{
  
  @Autowired
  private RoleMapper roleMapper;

  @Override
  public int createRole(Role role) {
    return roleMapper.insert(role);
  }

  @Override
  public Role selectByPrimaryKey(int id) {
    return roleMapper.selectByPrimaryKey(id);
  }
  
}

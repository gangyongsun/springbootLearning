package com.example.demo.service;

import com.example.demo.entity.Role;

public interface RoleService {
  int createRole(Role role);

  Role selectByPrimaryKey(int id);
}

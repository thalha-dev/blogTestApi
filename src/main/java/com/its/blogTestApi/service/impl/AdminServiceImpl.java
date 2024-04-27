package com.its.blogTestApi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.blogTestApi.entity.UserEntity;
import com.its.blogTestApi.repository.UserRepository;
import com.its.blogTestApi.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

}

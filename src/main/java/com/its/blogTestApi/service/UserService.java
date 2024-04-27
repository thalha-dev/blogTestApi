package com.its.blogTestApi.service;

import org.springframework.security.core.Authentication;

import com.its.blogTestApi.entity.UserEntity;

public interface UserService {

  UserEntity register(UserEntity newUser);

  UserEntity login(Authentication authentication);

}

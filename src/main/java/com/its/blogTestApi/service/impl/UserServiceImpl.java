package com.its.blogTestApi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.its.blogTestApi.entity.UserEntity;
import com.its.blogTestApi.repository.UserRepository;
import com.its.blogTestApi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public UserEntity register(UserEntity newUser) {
    // Encode the user's password
    String hashedPwd = passwordEncoder.encode(newUser.getPwd());
    newUser.setPwd(hashedPwd);

    // Validate the role (ensure it's either "READER" or "WRITER")
    String userRole = newUser.getUserRole();
    if (!"ROLE_READER".equals(userRole) && !"ROLE_WRITER".equals(userRole)) {
      throw new IllegalArgumentException("Invalid user role. Please provide either 'ROLE_READER' or 'ROLE_WRITER'.");
    }

    return userRepository.save(newUser);
  }
}

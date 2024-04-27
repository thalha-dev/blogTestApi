package com.its.blogTestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.its.blogTestApi.entity.UserEntity;
import com.its.blogTestApi.service.UserService;

@RestController
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/user/new")
  public ResponseEntity<String> createNewUser(@RequestBody UserEntity userForm) {

    try {
      // Validate mandatory fields
      if (userForm.getUserName() == null || userForm.getUserEmail() == null || userForm.getPwd() == null) {
        return ResponseEntity.badRequest().body("Please provide all mandatory fields (userName, userEmail, pwd).");
      }

      // Register the user
      userService.register(userForm);

      return ResponseEntity.status(HttpStatus.CREATED).body("Registration Success");
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("Error occurred during user registration: " + ex.getMessage());
    }
  }
}

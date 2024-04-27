package com.its.blogTestApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.its.blogTestApi.entity.UserEntity;
import com.its.blogTestApi.service.AdminService;

@RestController
public class AdminController {

  @Autowired
  private AdminService adminService;

  @GetMapping("/admin/getAllUsers")
  public ResponseEntity<List<UserEntity>> getAllUsers() {
    try {
      List<UserEntity> users = adminService.getAllUsers();
      return ResponseEntity.ok(users);
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body(null);
    }
  }
}

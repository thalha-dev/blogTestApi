package com.its.blogTestApi.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "user_pwd")
  private String pwd;

  @Column(name = "user_role")
  private String userRole;

  @Column(name = "user_age")
  private Integer userAge;

  // Constructors
  public UserEntity() {

  }

  public UserEntity(String userName, String userEmail, String pwd, String userRole, Integer userAge) {
    this.userName = userName;
    this.userEmail = userEmail;
    this.pwd = pwd;
    this.userRole = userRole;
    this.userAge = userAge;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getUserEmail() {
    return userEmail;
  }

  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }

  public String getUserRole() {
    return userRole;
  }

  public void setUserRole(String userRole) {
    this.userRole = userRole;
  }

  public Integer getUserAge() {
    return userAge;
  }

  public void setUserAge(Integer userAge) {
    this.userAge = userAge;
  }
}

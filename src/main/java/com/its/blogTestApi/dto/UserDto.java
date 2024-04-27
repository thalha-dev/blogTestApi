package com.its.blogTestApi.dto;

public class UserDto {
  private String userName;

  private String userEmail;

  private String userRole;

  private Integer userAge;

  // Constructors
  public UserDto() {

  }

  public UserDto(String userName, String userEmail, String userRole, Integer userAge) {
    this.userName = userName;
    this.userEmail = userEmail;
    this.userRole = userRole;
    this.userAge = userAge;
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

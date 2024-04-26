package com.its.blogTestApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long Id;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "user_email")
  private String userEmail;

  @Column(name = "user_role")
  private String userRole;

  @Column(name = "user_age")
  private Integer userAge;

}

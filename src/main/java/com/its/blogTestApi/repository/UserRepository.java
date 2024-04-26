package com.its.blogTestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.its.blogTestApi.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
  UserEntity findByUserEmail(String email);
}

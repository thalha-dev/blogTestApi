package com.its.blogTestApi.service;

import com.its.blogTestApi.entity.BookMarkEntity;

public interface BookMarkService {

  BookMarkEntity create(Long userId, Long blogId);

  void delete(Long userId, Long blogId);
}

package com.its.blogTestApi.service;

import org.springframework.data.domain.Page;

import com.its.blogTestApi.entity.BlogEntity;

public interface BlogService {

  BlogEntity create(BlogEntity blogForm);

  Page<BlogEntity> getAllBlogs(int page, int size);

  BlogEntity findById(Long blogId);
}

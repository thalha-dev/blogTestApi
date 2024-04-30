package com.its.blogTestApi.service.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.its.blogTestApi.entity.BlogEntity;
import com.its.blogTestApi.repository.BlogRepository;
import com.its.blogTestApi.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

  @Autowired
  private BlogRepository blogRepository;

  @Override
  public BlogEntity create(BlogEntity blogForm) {
    if (blogForm.getAuthorId() == null) {
      throw new IllegalArgumentException("Author ID is required");
    }

    if (blogForm.getBlogTitle() == null) {
      throw new IllegalArgumentException("Title is required");
    }

    if (blogForm.getBlogContents() == null) {
      throw new IllegalArgumentException("Content is required");
    }

    BlogEntity newBlog = new BlogEntity();
    newBlog.setBlogTitle(blogForm.getBlogTitle());
    newBlog.setBlogContents(blogForm.getBlogContents());
    newBlog.setAuthorId(blogForm.getAuthorId());
    newBlog.setBlogCreatedDate(Date.valueOf(LocalDate.now()));
    newBlog.setBlogModifiedDate(Date.valueOf(LocalDate.now()));

    return blogRepository.save(newBlog);
  }

  @Override
  public Page<BlogEntity> getAllBlogs(int page, int size) {
    if (page < 0) {
      page = 0;
    }

    if (size < 0) {
      size = 10;
    }
    // Retrieve a paginated list of blogs
    return blogRepository.findAll(PageRequest.of(page, size));
  }

  public BlogEntity findById(Long blogId) {
    Optional<BlogEntity> blogOpt = blogRepository.findById(blogId);

    if (!blogOpt.isPresent()) {

      throw new IllegalArgumentException("Blog ID is not valid");
    }

    return blogOpt.get();
  }

}

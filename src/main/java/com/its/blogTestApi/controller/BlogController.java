package com.its.blogTestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.its.blogTestApi.entity.BlogEntity;
import com.its.blogTestApi.service.BlogService;

@RestController
public class BlogController {

  @Autowired
  private BlogService blogService;

  @PostMapping("/blog/new")
  public ResponseEntity<String> createNewBlog(@RequestBody BlogEntity blogForm) {
    try {
      blogService.create(blogForm);
      return ResponseEntity.status(HttpStatus.CREATED).body("Blog Created");
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("Error occurred during blog creation: " + ex.getMessage());
    }
  }

  @GetMapping("/blogs")
  public ResponseEntity<Page<BlogEntity>> getAllBlogs(@RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "10") int size) {
    Page<BlogEntity> blogPage = blogService.getAllBlogs(page, size);
    return ResponseEntity.ok(blogPage);
  }

  @GetMapping("/blog/{id}")
  public ResponseEntity<BlogEntity> getBlogById(@PathVariable Long id) {
    BlogEntity blog = blogService.findById(id);
    return ResponseEntity.ok(blog);
  }
}

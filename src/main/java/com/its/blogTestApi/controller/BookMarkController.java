package com.its.blogTestApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.its.blogTestApi.service.BookMarkService;

@RestController
public class BookMarkController {

  @Autowired
  private BookMarkService bookMarkService;

  @PostMapping("/bookmark/new/{userId}/{blogId}")
  public ResponseEntity<String> create(@PathVariable Long userId, @PathVariable Long blogId) {
    try {
      bookMarkService.create(userId, blogId);
      return ResponseEntity.status(HttpStatus.CREATED).body("Bookmark Created");
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("Error occurred during bookmark creation: " + ex.getMessage());
    }
  }

  @DeleteMapping("/bookmark/delete/{userId}/{blogId}")
  public ResponseEntity<String> delete(@PathVariable Long userId, @PathVariable Long blogId) {
    try {
      bookMarkService.delete(userId, blogId);
      return ResponseEntity.status(HttpStatus.OK).body("Bookmark Deleted");
    } catch (Exception ex) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST)
          .body("Error occurred during bookmark deletion: " + ex.getMessage());
    }
  }

}

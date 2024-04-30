package com.its.blogTestApi.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.its.blogTestApi.entity.BookMarkEntity;
import com.its.blogTestApi.repository.BookMarkRepository;
import com.its.blogTestApi.service.BookMarkService;

@Service
public class BookMarkServiceImpl implements BookMarkService {

  @Autowired
  private BookMarkRepository bookMarkRepository;

  @Override
  public BookMarkEntity create(Long userId, Long blogId) {
    Optional<BookMarkEntity> bookMarkOpt = bookMarkRepository.findByUserIdAndBlogId(userId, blogId);
    if (bookMarkOpt.isEmpty()) {
      throw new IllegalArgumentException("Invalid user ID or blog Id");
    }

    return bookMarkOpt.get();

  }

  @Override
  public void delete(Long userId, Long blogId) {
    Optional<BookMarkEntity> bookMarkOpt = bookMarkRepository.findByUserIdAndBlogId(userId, blogId);
    if (bookMarkOpt.isPresent()) {
      bookMarkRepository.delete(bookMarkOpt.get());
    } else {
      throw new IllegalArgumentException("Invalid user ID or blog Id");
    }
  }

}

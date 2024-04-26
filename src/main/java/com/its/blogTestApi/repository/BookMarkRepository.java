package com.its.blogTestApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.its.blogTestApi.entity.BookMarkEntity;

@Repository
public interface BookMarkRepository extends JpaRepository<BookMarkEntity, Long> {

}

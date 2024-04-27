package com.its.blogTestApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name = "user_bookmarks", uniqueConstraints = { @UniqueConstraint(columnNames = { "user_id", "blog_id" }) })
public class BookMarkEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @ManyToOne(targetEntity = UserEntity.class)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private Long userId;

  @ManyToOne(targetEntity = BlogEntity.class)
  @JoinColumn(name = "blog_id", referencedColumnName = "id")
  private Long blogId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getBlogId() {
    return blogId;
  }

  public void setBlogId(Long blogId) {
    this.blogId = blogId;
  }

  public BookMarkEntity(Long id, Long userId, Long blogId) {
    super();
    this.id = id;
    this.userId = userId;
    this.blogId = blogId;
  }

  public BookMarkEntity() {
    super();
  }

}

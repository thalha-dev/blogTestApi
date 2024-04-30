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

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
  private UserEntity user;

  @Column(name = "user_id")
  private Long userId;

  @ManyToOne
  @JoinColumn(name = "blog_id", referencedColumnName = "id", insertable = false, updatable = false)
  private BlogEntity blog;

  @Column(name = "blog_id")
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

  public BookMarkEntity(Long id, Long userId, Long blogId, BlogEntity blog, UserEntity user) {
    super();
    this.id = id;
    this.userId = userId;
    this.blogId = blogId;
    this.blog = blog;
    this.user = user;
  }

  public BookMarkEntity() {
    super();
  }

  public BlogEntity getBlog() {
    return blog;
  }

  public void setBlog(BlogEntity blog) {
    this.blog = blog;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }
}

package com.its.blogTestApi.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.sql.Date;

@Entity
@Table(name = "blog")
public class BlogEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "blog_title")
  private String blogTitle;

  @Column(name = "blog_content")
  private String blogContent;

  @Column(name = "blog_created_date")
  private Date blogCreatedDate;

  @Column(name = "blog_modified_date")
  private Date blogModifiedDate;

  @ManyToOne(targetEntity = UserEntity.class)
  @JoinColumn(name = "author_id", referencedColumnName = "id")
  private Long authorId;

  // Constructors
  public BlogEntity() {

  }

  public BlogEntity(String blogTitle, String blogContent, Date blogCreatedDate, Date blogModifiedDate, Long authorId) {
    this.blogTitle = blogTitle;
    this.blogContent = blogContent;
    this.blogCreatedDate = blogCreatedDate;
    this.blogModifiedDate = blogModifiedDate;
    this.authorId = authorId;
  }

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getBlogTitle() {
    return blogTitle;
  }

  public void setBlogTitle(String blogTitle) {
    this.blogTitle = blogTitle;
  }

  public String getBlogContent() {
    return blogContent;
  }

  public void setBlogContent(String blogContent) {
    this.blogContent = blogContent;
  }

  public Date getBlogCreatedDate() {
    return blogCreatedDate;
  }

  public void setBlogCreatedDate(Date blogCreatedDate) {
    this.blogCreatedDate = blogCreatedDate;
  }

  public Date getBlogModifiedDate() {
    return blogModifiedDate;
  }

  public void setBlogModifiedDate(Date blogModifiedDate) {
    this.blogModifiedDate = blogModifiedDate;
  }

  public Long getAuthorId() {
    return authorId;
  }

  public void setAuthorId(Long authorId) {
    this.authorId = authorId;
  }
}

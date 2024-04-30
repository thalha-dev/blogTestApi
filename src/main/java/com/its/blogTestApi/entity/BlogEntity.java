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

  @Column(name = "blog_contents", length = 65555)
  private String blogContents;

  @Column(name = "blog_created_date")
  private Date blogCreatedDate;

  @Column(name = "blog_modified_date")
  private Date blogModifiedDate;

  @ManyToOne
  @JoinColumn(name = "author_id", referencedColumnName = "id", insertable = false, updatable = false)
  private UserEntity author;

  @Column(name = "author_id")
  private Long authorId;

  public BlogEntity() {
    super();
  }

  public BlogEntity(Long id, String blogTitle, String blogContents, Date blogCreatedDate, Date blogModifiedDate,
      Long authorId) {
    super();
    this.id = id;
    this.blogTitle = blogTitle;
    this.blogContents = blogContents;
    this.blogCreatedDate = blogCreatedDate;
    this.blogModifiedDate = blogModifiedDate;
    this.authorId = authorId;
  }

  public BlogEntity(Long id, String blogTitle, String blogContents, Date blogCreatedDate, Date blogModifiedDate,
      Long authorId, UserEntity author) {
    super();
    this.id = id;
    this.blogTitle = blogTitle;
    this.blogContents = blogContents;
    this.blogCreatedDate = blogCreatedDate;
    this.blogModifiedDate = blogModifiedDate;
    this.authorId = authorId;
    this.author = author;
  }

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

  public String getBlogContents() {
    return blogContents;
  }

  public void setBlogContents(String blogContents) {
    this.blogContents = blogContents;
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

  public UserEntity getAuthor() {
    return author;
  }

  public void setAuthor(UserEntity author) {
    this.author = author;
  }

}

package com.its.blogTestApi.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "blog")
public class BlogEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long Id;

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

}

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
  private Long authorId;
}

package com.sys.gin.entities;

import java.util.Date;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

@EntityListeners(AuditingEntityListener.class)
@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {
  @CreatedDate()
  @Column(name = "created_at", nullable = false)
  private Date createdAt;

  @LastModifiedDate
  @Column(name = "updated_at", nullable = false)
  private Date updatedAt;

  @PrePersist
  public void perPersist() {
    this.createdAt = new Date();
  }

  @PreUpdate
  public void preUpdate() {
    this.updatedAt = new Date();
  }
}

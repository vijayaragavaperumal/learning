package com.self.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity(name = "users")
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@Getter
@Setter
public class UserEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", unique = true, nullable = false)
  private String name;

  @Column(name = "age", unique = false, nullable = false)
  private int age;

  @Column(name = "emailId", unique = true, nullable = false)
  private String emailId;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
  private List<UserProperties> properties;

  @CreatedDate
  @Column(name = "createddate")
  @Temporal(TemporalType.TIMESTAMP)
  @Getter
  private Date createdDate;

  @LastModifiedDate
  @Column(name = "updateddate")
  @Temporal(TemporalType.TIMESTAMP)
  private Date updatedDate;
}

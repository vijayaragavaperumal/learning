package com.self.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity(name = "userproperties")
@Table(name = "userproperties")
@EntityListeners(AuditingEntityListener.class)
@Accessors(chain = true)
@Getter
@Setter
public class UserProperties implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userid")
  private UserEntity user;

  @Column(name = "key", unique = true, nullable = false)
  private String key;

  @Column(name = "value", unique = false, nullable = true)
  private String value;
}

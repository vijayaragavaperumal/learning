package com.self.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.self.entities.UserProperties;

import lombok.Data;

@Data
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String name;

  private int age;

  private String emailId;

  private List<UserProperties> properties;

  private Date createdDate;

  private Date updatedDate;
}

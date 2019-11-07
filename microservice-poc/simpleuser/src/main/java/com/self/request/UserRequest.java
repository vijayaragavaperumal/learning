package com.self.request;

import java.io.Serializable;

import com.self.model.User;

import lombok.Data;

@Data
public class UserRequest implements Serializable{

  private static final long serialVersionUID = 1L;
  
  private User user;
}

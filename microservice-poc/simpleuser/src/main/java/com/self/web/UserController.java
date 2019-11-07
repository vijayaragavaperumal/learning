package com.self.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.self.entities.UserEntity;
import com.self.model.User;
import com.self.request.UserRequest;
import com.self.service.UserService;

@RestController
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/ping")
  public String ping() {
    return "Service up, Current Time is " + System.currentTimeMillis();
  }

  @GetMapping("/users")
  public ResponseEntity<Object> getAllUserEntitys() {
    return new ResponseEntity<>(userService.getAllUserEntitys(), HttpStatus.OK);
  }

  @GetMapping("/users/{id}")
  public ResponseEntity<Object> getUser(@PathVariable("id") long id) {
    return new ResponseEntity<>(userService.getUserEntityById(id), HttpStatus.OK);
  }

  @DeleteMapping("/users/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") long id) {
    userService.delete(id);
    return new ResponseEntity<>("", HttpStatus.ACCEPTED);
  }

  @PostMapping("/users")
  public ResponseEntity<Object> createUser(@RequestBody UserRequest userReq) {
    UserEntity userEntity = new UserEntity();
    User userData = userReq.getUser();
    userEntity.setAge(userData.getAge());
    userEntity.setEmailId(userData.getEmailId());
    userEntity.setName(userData.getName());
    userEntity.setProperties(userData.getProperties());
    return new ResponseEntity<>(userService.save(userEntity), HttpStatus.CREATED);
  }

}

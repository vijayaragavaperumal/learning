package com.self.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.self.entities.UserEntity;
import com.self.entities.UserProperties;
import com.self.repository.UserPropertiesRepository;
import com.self.repository.UserRepository;

@Service
public class UserService {

  private UserRepository userRepository;

  private UserPropertiesRepository userPropertiesRepository;

  public UserService(UserRepository userRepository, UserPropertiesRepository userPropertiesRepository) {
    super();
    this.userRepository = userRepository;
    this.userPropertiesRepository = userPropertiesRepository;
  }

  public List<UserEntity> getAllUserEntitys() {
    List<UserEntity> userEntitys = new ArrayList<>();
    userRepository.findAll().forEach(userEntity -> userEntitys.add(userEntity));
    return userEntitys;
  }

  public UserEntity getUserEntityById(Long id) {
    UserEntity user = null;
    Optional<UserEntity> userObj = userRepository.findById(id);
    if (userObj.isPresent()) {
      user = userObj.get();
    }
    return user;
  }

  public UserEntity save(UserEntity userReq) {
    UserEntity user = userRepository.save(userReq);
    List<UserProperties> userProps = userReq.getProperties();
    userProps.stream().forEach(prop -> prop.setUser(user));
    userPropertiesRepository.saveAll(userProps);
    return user;
  }

  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}

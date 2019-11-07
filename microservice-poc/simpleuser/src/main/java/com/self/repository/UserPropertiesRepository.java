package com.self.repository;

import org.springframework.data.repository.CrudRepository;

import com.self.entities.UserProperties;

public interface UserPropertiesRepository extends CrudRepository<UserProperties, Long> {
  UserProperties findOneByUserId(long userId);
}

package com.self.repository;

import org.springframework.data.repository.CrudRepository;

import com.self.entities.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {}  
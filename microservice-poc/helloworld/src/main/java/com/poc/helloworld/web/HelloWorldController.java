/*******************************************************************************
 * Copyright ©2002-2019 Skava - All rights reserved.
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof, 
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited. 
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * For further information contact Skava at info@skava.com.
 ******************************************************************************/
package com.poc.helloworld.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.helloworld.getandsetmodel.GetterAndSetterModel;
import com.poc.helloworld.service.ArithmeticService;

@RestController
public class HelloWorldController {

  @Autowired
  ArithmeticService arithmeticservice;

  @GetMapping(value = "/")
  public String helloWorld() {
    return "Hello Microservice Word";
  }

  @GetMapping(value = "/add", params = {"a", "b"})
  public int add(int a, int b) {
    return arithmeticservice.addInterger(a, b);
  }
  
  @GetMapping(value = "/model", params = {"id", "name"})
  public GetterAndSetterModel modelCheck(int id, String name) {
    GetterAndSetterModel getterAndSetterModel = new GetterAndSetterModel();
    getterAndSetterModel.setId(id);
    getterAndSetterModel.setName(name);
    return getterAndSetterModel;
  }
}

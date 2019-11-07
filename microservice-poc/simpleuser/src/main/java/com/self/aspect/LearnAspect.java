package com.self.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Slf4j
@Configuration
public class LearnAspect {

  @Before("execution(* com.self.service.UserService.*(..))") // point-cut expression
  public void logBeforeV1(JoinPoint joinPoint) {
    log.debug("Aspect break down " + joinPoint.getSignature().getName());
  }
  
  @After("execution(* com.self.service.UserService.*(..))") // point-cut expression
  public void logAfterV1(JoinPoint joinPoint) {
    log.debug("Aspect break down " + joinPoint.getSignature().getName());
  }
}

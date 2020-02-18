package com.skava.camel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import lombok.extern.slf4j.Slf4j;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = "com.skava")
@Slf4j
@EnableSwagger2
@ImportResource({"classpath:routes.xml"})
public class CamelApplication {
  public static void main(String[] args) {
    try {
      SpringApplication.run(CamelApplication.class, args);
    } catch (Exception e) {
      log.info("Exception in main", e);
    }
  }
}

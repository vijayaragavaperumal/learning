/**********************************************************************************
 Copyright ©2002-2018 Skava - All rights reserved.
 * 
 * All information contained herein is, and remains the property of Skava.
 * Skava including, without limitation, all software and other elements thereof,
 * are owned or controlled exclusively by Skava and protected by copyright, patent
 * and other laws. Use without permission is prohibited.
 * Unauthorized copying of this file, via any medium is strictly prohibited
 *  
 * For further information contact Skava at info@skava.com.
 *********************************************************************************/
package com.skava;

import org.apache.camel.zipkin.starter.CamelZipkin;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.skava.core.yaml.YamlPropertySourceFactory;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>OrchestrationApplication class.</p>
 *
 * @author Vanchinathan.R01
 * @version 8.0
 */
@SpringBootApplication
@ImportResource({"classpath:routes.xml"})
@PropertySource(value = {"classpath:swagger.yml"}, factory = YamlPropertySourceFactory.class)
@CamelZipkin
@EnableSwagger2
public class OrchestrationApplication {
  /**
   * <p>main.</p>
   *
   * @param args an array of {@link java.lang.String} objects.
   */
  public static void main(String[] args) {
    SpringApplication.run(OrchestrationApplication.class, args);
  }
}

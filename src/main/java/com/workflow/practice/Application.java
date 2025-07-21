package com.workflow.practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(scanBasePackages = {"com.workflow.practice", "com.workflow.controllers", "com.workflow.delegates", "com.workflow.services"})
public class Application {

  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }

}


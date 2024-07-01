package com.example.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements CommandLineRunner {

  @Order(2)
  @Override
  public void run(String... args) throws Exception {
    System.out.println("============CommandLineRunner==============");
  }
}
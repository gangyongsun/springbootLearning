package com.example.demo.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Description: Description
 * @ProjectName: spring-parent
 * @Version: 1.0
 */
@Component
@Order(0)
public class YellowPersion implements CommandLineRunner {
  @Override
  public void run(String... args) throws Exception {
    System.out.println("----YellowPersion----");
  }
}
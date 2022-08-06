package com.example.demo;

import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TestForDtchApplication {

	@SneakyThrows
	public static void main(String[] args) {SpringApplication.run(TestForDtchApplication.class, args);}
}

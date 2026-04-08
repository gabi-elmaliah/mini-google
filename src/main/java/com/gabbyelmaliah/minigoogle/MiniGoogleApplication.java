package com.gabbyelmaliah.minigoogle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MiniGoogleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiniGoogleApplication.class, args);
	}

}

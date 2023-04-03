package com.transport.ts101;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class Ts101Application {

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC+05:30"));
	}

	public static void main(String[] args) {
		SpringApplication.run(Ts101Application.class, args);
	}

}

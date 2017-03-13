package com.harryseong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HarrySeongApp {

    private static final Logger log = LoggerFactory.getLogger(HarrySeongApp.class);

    public static void main(String[] args) {
		SpringApplication.run(HarrySeongApp.class, args);
	}
}

package com.harryseong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class HarryseongSpringbootApplication {

    private static final Logger log = LoggerFactory.getLogger(HarryseongSpringbootApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(HarryseongSpringbootApplication.class, args);
	}

    @Bean
    public CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            // save a couple of books
            repository.save(new Book("Webster's Dictionary"));

            // fetch all books
            log.info("Books found with findAll():");
            log.info("-------------------------------");
            for (Book book : repository.findAll()) {
                log.info(book.toString());
            }
            log.info("");
        };
    }
}

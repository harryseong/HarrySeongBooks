package com.harryseong.service;

import com.harryseong.HarrySeongApp;
import com.harryseong.domain.Book;
import com.harryseong.repository.BookRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by harry on 3/9/17.
 */

@Service
public class BookDBImport {

    private static final Logger log = LoggerFactory.getLogger(HarrySeongApp.class);

    @Autowired
    BookRepository bookRepository;

    public void testDBImport() throws IOException {
        // save a couple of books via csv file
        File file = new File("/Users/harry/bookDatabase.csv");
        Scanner scanner = new Scanner(file);
        Scanner dataScanner = null;
        int index = 0;

        // While there's another book left in the csv file:
        while (scanner.hasNextLine()) {
            dataScanner = new Scanner(scanner.nextLine());
            dataScanner.useDelimiter(",");
            Book book = new Book();

            // While there's another book attribute left for the book in the csv file:
            while (dataScanner.hasNext()) {
                String data = dataScanner.next();
                if (index == 0) {
                    book.setBookID(Long.parseLong(data));
                } else if (index == 1) {
                    book.setTitle(data);
                } else if (index == 2) {
                    book.setAuthorFName(data);
                } else if (index == 3) {
                    book.setAuthorMName(data);
                } else if (index == 4) {
                    book.setAuthorLName(data);
                } else if (index == 5) {
                    book.setNumberOfPages(Integer.parseInt(data));
                } else if (index == 6) {
                    book.setIsbn13(data);
                } else if (index == 7) {
                    book.setReadStatus(Boolean.parseBoolean(data));
                }
                index++;
                bookRepository.save(book);
            }
            index = 0;
        }
        scanner.close();
    }

    @Bean
    public CommandLineRunner test() throws IOException {
        testDBImport();

        return (args) -> {
            // save a couple of books (for testing purposes)
            // bookRepositoryOutput.save(new Book("Webster's Dictionary"));
            // bookRepositoryOutput.save(new Book("Going the Second Mile"));

            // fetch all books
            log.info("Books found with findAll():");
            log.info("-------------------------------");
            for (Book book : bookRepository.findAll()) {
                log.info(book.toString());
            }
            log.info("");
        };
    }
}



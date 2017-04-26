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
 * Created by harry on 3/9/17. Imports initial set of books into database from csv file.
 */

@Service
public class BookDBImport {

    private static final Logger log = LoggerFactory.getLogger(HarrySeongApp.class);

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private ImportBookJson importBookJson;

    public void initialBookDBImport() throws IOException {
        // save a couple of books via csv file
        File file = new File("/Users/harry/bookDatabase2.csv");
        Scanner scanner = new Scanner(file);
        Scanner dataScanner = null;
        int index = 0;

        // While there's another book left in the csv file:
        while (scanner.hasNextLine()) {
            dataScanner = new Scanner(scanner.nextLine());
            dataScanner.useDelimiter(",");
            Book book = new Book();
            String isbn13 = "";

            // While there's another book attribute left for the book in the csv file:
            while (dataScanner.hasNext()) {
                String data = dataScanner.next();
                if (index == 2) {
                    // Sanitize isbn13 number
                    isbn13=data.replaceAll("[^0-9]","");
                    book.setIsbn13(isbn13);
                }
                else if (index == 3) {
                    book.setReadStatus(Boolean.parseBoolean(data));
                }
                index++;
            }
            book= importBookJson.importBookJson(book, isbn13);
            bookRepository.save(book);
            index = 0;
        }
        scanner.close();
    }

    @Bean
    public CommandLineRunner test() throws IOException {

        initialBookDBImport();

        return (args) -> {
            // Fetch all books
            log.info("Books found with findAll():");
            log.info("-------------------------------");
            for (Book book : bookRepository.findAll()) {
                log.info(book.toString());
            }
            log.info("");
        };
    }
}



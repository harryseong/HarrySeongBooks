package com.harryseong.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harryseong.HarrySeongApp;
import com.harryseong.domain.Book;
import com.harryseong.repository.BookRepository;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by harry on 3/9/17.
 */

@Service
public class BookDBImport {

    private static final Logger log = LoggerFactory.getLogger(HarrySeongApp.class);

    @Autowired
    BookRepository bookRepository;

    public void initialBookDBImport() throws IOException {
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
            String isbn13 = "";

            // While there's another book attribute left for the book in the csv file:
            while (dataScanner.hasNext()) {
                String data = dataScanner.next();

                if (index == 2) {
                    // sanitize isbn13 number
                    isbn13=data.replaceAll("[^0-9]","");
                    book.setIsbn13(isbn13);
                }
                else if (index == 3) {
                    book.setReadStatus(Boolean.parseBoolean(data));
                }
                index++;
            }

            // Test with locally stored sample JSON
            byte[] bookJsonString = Files.readAllBytes(Paths.get("/Users/harry/downloads/bookJsonFile.txt"));

            // Test with Google Books API + fixed ISBN number
            //JSONObject bookJsonObject = new JSONObject(IOUtils.toString(new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:9780399588174"), Charset.forName("UTF-8")));
            //String bookJsonString = bookJsonObject.toString();

            // Google Books API + database-stored ISBN number
            //JSONObject bookJsonObject = new JSONObject(IOUtils.toString(new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:"+isbn13), Charset.forName("UTF-8")));
            //String bookJsonString = bookJsonObject.toString();

            ObjectMapper objectMapper = new ObjectMapper();

            try {
                JsonNode rootNode = objectMapper.readValue(bookJsonString, JsonNode.class);
                    JsonNode itemsArray = rootNode.get("items");
                        JsonNode itemsNode = itemsArray.get(0);
                            JsonNode volumeInfoNode = itemsNode.get("volumeInfo");
                                JsonNode titleNode = volumeInfoNode.get("title");
                                JsonNode authorsArray = volumeInfoNode.get("authors");
                                    JsonNode authorNode = authorsArray.get(0);
                                JsonNode descriptionNode = volumeInfoNode.get("description");
                                JsonNode pageCountNode = volumeInfoNode.get("pageCount");
                                JsonNode imageLinksNode = volumeInfoNode.get("imageLinks");
                                    JsonNode thumbnailNode = imageLinksNode.get("thumbnail");
                                    JsonNode smallThumbnailNode = imageLinksNode.get("smallThumbnail");
                book.setTitle(titleNode.asText());
                book.setAuthorName(authorNode.asText());
                // book.setDescription(descriptionNode.asText());
                book.setDescription("This is a sample description.");
                book.setPageCount(pageCountNode.asInt());
                book.setCoverImageURL(smallThumbnailNode.asText());
            } catch (IOException e) {
                e.printStackTrace();
            }
            bookRepository.save(book);
            index = 0;
        }
        scanner.close();
    }

    @Bean
    public CommandLineRunner test() throws IOException {

        initialBookDBImport();

        return (args) -> {
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



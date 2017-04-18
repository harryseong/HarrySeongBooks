package com.harryseong.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.harryseong.HarrySeongApp;
import com.harryseong.domain.Book;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 * Created by harry on 4/17/17.
 */
public class ParseBookJson {

    private static final Logger log = LoggerFactory.getLogger(HarrySeongApp.class);

    public Book parseBookJson(Book book, String isbn13) throws IOException {

        JSONObject bookJsonObject = new JSONObject(IOUtils.toString(new URL("https://www.googleapis.com/books/v1/volumes?q=isbn:"+isbn13), Charset.forName("UTF-8")));
        String bookJsonString = bookJsonObject.toString();
        ObjectMapper objectMapper = new ObjectMapper();
        // log.info(isbn13);

        try {
            JsonNode rootNode = objectMapper.readValue(bookJsonString, JsonNode.class);

            // check if null, if null, skip rest and print out to log
            JsonNode totalItemsNode = rootNode.get("totalItems");
            int totalItems = totalItemsNode.asInt();

            if (totalItems > 0) {
                JsonNode itemsArray = rootNode.get("items");
                JsonNode itemsNode = itemsArray.get(0);
                JsonNode volumeInfoNode = itemsNode.get("volumeInfo");

                JsonNode titleNode = volumeInfoNode.get("title");
                book.setTitle(titleNode.asText());

                if (volumeInfoNode.has("authors")){
                    JsonNode authorsArray = volumeInfoNode.get("authors");
                    JsonNode authorNode = authorsArray.get(0);
                    book.setAuthorName(authorNode.asText());
                }
                else {
                    log.info("No authors for book with ISBN-13 number, "+isbn13+", this book.");
                    book.setAuthorName("N/A");
                }

                JsonNode pageCountNode = volumeInfoNode.get("pageCount");
                book.setPageCount(pageCountNode.asInt());

                if (volumeInfoNode.has("imageLinks")){
                    JsonNode imageLinksNode = volumeInfoNode.get("imageLinks");
                    // this is for bigger version of the book cover thumbnail
                    JsonNode thumbnailNode = imageLinksNode.get("thumbnail");
                    JsonNode smallThumbnailNode = imageLinksNode.get("smallThumbnail");
                    book.setCoverImageURL(smallThumbnailNode.asText());
                }
                else {
                    log.info("No imageLinks available for book with ISBN-13 number, "+isbn13+", this book.");
                }

                if (volumeInfoNode.has("description")){
                    JsonNode descriptionNode = volumeInfoNode.get("description");
                    book.setDescription(descriptionNode.asText());
                }
                else {
                    log.info("No description available for book with ISBN-13 number, "+isbn13+", this book.");
                }
            }
            else if (totalItems == 0) {
                log.info("The book associated with the ISBN-13 number, "+isbn13+", is not found on the Google Books API.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return book;
    }
}

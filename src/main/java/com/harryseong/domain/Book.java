package com.harryseong.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by harry on 2/24/17.
 */

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long bookID;
    private String title;
    private String authorName;
    private String description;
    private int pageCount;
    private String isbn13;
    private boolean readStatus;
    private String coverImageURL;

    // No arg constructor needed for JPA
    public Book(){
    }

    // Constructor for adding new book
    public Book(String isbn13, boolean readStatus){
        setIsbn13(isbn13);
        setReadStatus(readStatus);
    }

    // Setters
    public void setBookID(Long bookID){
        this.bookID=bookID;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthorName(String authorName){
        this.authorName=authorName;
    }
    public void setDescription(String description){
        this.description=description;
    }
    public void setPageCount(int pageCount){ this.pageCount = pageCount; }
    public void setIsbn13(String isbn13){
        this.isbn13=isbn13;
    }
    public void setReadStatus(boolean readStatus){
        this.readStatus=readStatus;
    }
    public void setCoverImageURL(String coverImageURL) { this.coverImageURL=coverImageURL; }

    // Getters
    public String getBookID(){
        return String.format(String.valueOf(bookID));
    }
    public String getTitle(){
        return title;
    }
    public String getAuthorName() { return authorName; }
    public String getDescription() { return description; }
    public String getPageCount(){
        return String.valueOf(pageCount);
    }
    public String getIsbn13(){
        return (isbn13);
    }
    public String getReadStatus(){
        return String.valueOf(readStatus);
    }
    public String getCoverImageURL(){
        return coverImageURL;
    }

    @Override
    public String toString() {
        return String.format("["+getBookID()+", "+getTitle()+", "
                +getAuthorName()+", "+ getPageCount()+", "+getIsbn13()+", "+getReadStatus()+", "+getCoverImageURL()+"]");
    }
}

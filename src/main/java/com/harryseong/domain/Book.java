package com.harryseong.domain;

import com.harryseong.constraints.ISBN;
import javax.persistence.*;
import javax.validation.constraints.Size;

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
    @Column(length = 5000)
    private String description;
    private int pageCount;
    @ISBN
    @Size(min=13, max=13)
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
        String isbn13Unclean=isbn13;
        String isbn13Clean=isbn13Unclean.replaceAll("[^0-9]","");
        this.isbn13=isbn13Clean;
    }
    public void setReadStatus(boolean readStatus){
        this.readStatus=readStatus;
    }
    public void setCoverImageURL(String coverImageURL) { this.coverImageURL=coverImageURL; }

    // Getters
    public Long getBookID(){ return bookID;}
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
        return String.format("["+String.format(String.valueOf(getBookID()))+", "+getTitle()+", "
                +getAuthorName()+", "+ getPageCount()+", "+getIsbn13()+", "+getReadStatus()+", "+getCoverImageURL()+", "+getDescription()+"]");
    }
}

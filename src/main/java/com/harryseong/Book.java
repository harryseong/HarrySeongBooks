package com.harryseong;

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
    private int bookID;

    private String title;
    private String authorFName;
    private String authorMName;
    private String authorLName;
    private int numberOfPages;
    private String isbn13;
    private boolean readStatus;

    // Protected no arg constructor needed for JPA
    protected Book(){
    }

    // Constructor
    public Book(int bookID, String title, String authorFName, String authorMName,
                String authorLName, int numberOfPages, String isbn13,
                boolean readStatus){
        this.setBookID(bookID);
        this.setTitle(title);
        this.setAuthorFName(authorFName);
        this.setAuthorMName(authorMName);
        this.setAuthorLName(authorLName);
        this.setNumberOfPages(numberOfPages);
        this.setIsbn13(isbn13);
        this.setReadStatus(readStatus);
    }

    public Book(String title){
        this.setTitle(title);
    }

    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s']", bookID, title);
    }

    // Setters
    public void setBookID(int bookID){
        this.bookID=bookID;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setAuthorFName(String authorFName){
        this.authorFName=authorFName;
    }
    public void setAuthorMName(String authorMName){
        this.authorMName=authorMName;
    }
    public void setAuthorLName(String authorLName){
        this.authorLName=authorLName;
    }
    public void setNumberOfPages(int numberOfPages){
        this.numberOfPages=numberOfPages;
    }
    public void setIsbn13(String isbn13){
        this.isbn13=isbn13;
    }
    public void setReadStatus(boolean readStatus){
        this.readStatus=readStatus;
    }

    // Getters
    public int getBookID(){
        return bookID;
    }
    public String getAuthorFName(){
        return authorFName;
    }
    public String getAuthorMName(){
        return authorMName;
    }
    public String getAuthorLName(){
        return authorLName;
    }
    public String getTitle(){
        return title;
    }
    public int getNumberOfPages(){
        return numberOfPages;
    }
    public String getIsbn13(){
        return isbn13;
    }
    public boolean getReadStatus(){
        return readStatus;
    }
}

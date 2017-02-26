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
    //private String authorFullName; // only for quick reference
    private int numberOfPages;
    private String isbn13;
    private boolean readStatus;

    /* Book constructor
    public Book(String title, String authorFName, String authorMName,
                String authorLName, int numberOfPages, String isbn13,
                boolean readStatus){
        this.title=title;
        this.authorFName=authorFName;
        this.authorMName=authorMName;
        this.authorLName=authorLName;
        this.numberOfPages=numberOfPages;
        this.isbn13=isbn13;
        this.readStatus=readStatus;

        // authorFullName based on absence/presence of authorMName
        if(authorMName != null && !authorMName.isEmpty()){
            this.authorFullName=authorFName+" "+authorMName+" "+authorLName;
        }
        else if(authorMName == null || authorMName.isEmpty()){
            this.authorFullName=authorFName+" "+authorLName;
        }
    }
    */

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
    public String getTitle(){
        return title;
    }
    /*
    public String getAuthorFullName(){
        return authorFullName;
    }
    */
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

package com.harryseong.repository;

import org.springframework.data.repository.CrudRepository;
import com.harryseong.domain.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by harry on 2/24/17.
 */

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);
    List<Book> findByAuthorName(String authorFName);
    Book findByIsbn13(String isbn13);
    Book findByBookID(Long bookID);
}
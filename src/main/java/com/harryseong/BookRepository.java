package com.harryseong;

import org.springframework.data.repository.CrudRepository;
import com.harryseong.Book;

import java.util.List;

/**
 * Created by harry on 2/24/17.
 */

public interface BookRepository extends CrudRepository<Book, Integer> {
    List<Book> findByTitle(String title);
}
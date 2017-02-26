package com.harryseong;

import org.springframework.data.repository.CrudRepository;
import com.harryseong.Book;

/**
 * Created by harry on 2/24/17.
 */

public interface BookRepository extends CrudRepository<Book, Long> {

}
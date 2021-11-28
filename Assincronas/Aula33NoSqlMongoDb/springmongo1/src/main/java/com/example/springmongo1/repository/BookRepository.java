package com.example.springmongo1.repository;

import com.example.springmongo1.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends MongoRepository<Book, String> {

    List<Book> finsBooksByAuthor(String author);
}

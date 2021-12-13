package com.example.springmongo2.repository;

import com.example.springmongo2.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends MongoRepository<Book, String> {}

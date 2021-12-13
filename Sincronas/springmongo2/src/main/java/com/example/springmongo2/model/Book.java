package com.example.springmongo2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "books")
public class Book {

    @Id
    private String id;
    private String author;

    @Field(name = "book")
    private String bookTitle;
}

package com.example.springmongo2.service;

import com.example.springmongo2.model.Book;
import com.example.springmongo2.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> findAllbooks() {
        return bookRepository.findAll();
    }
}

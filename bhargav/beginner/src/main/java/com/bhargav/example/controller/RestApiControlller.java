package com.bhargav.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhargav.example.daos.Book;
import com.bhargav.example.services.BookService;

@RestController
public class RestApiControlller {
    @Autowired
    BookService bookService;
    @GetMapping("/home/books/{bookId}")
    public Book getBook(@PathVariable String bookId)
    {
        System.out.println("hello world");
        return bookService.getBook(bookId);
    }
}

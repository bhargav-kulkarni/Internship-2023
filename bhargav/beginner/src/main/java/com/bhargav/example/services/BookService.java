package com.bhargav.example.services;

import static java.time.LocalTime.now;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bhargav.example.daos.Book;

@Service
public class BookService {
    List<Book> booklist = new ArrayList<>();

    public Book getBook(String id){

        HashMap<String, Book> booksMap = new HashMap<>();
        Date date = new Date();
        date.setHours(0);
        Book book1 = new Book("123","Java",100,date,9);
        booksMap.put("1",book1);
        booksMap.put("2",book1);
        booksMap.put("3",book1);
        booksMap.put("4",book1);

        return booksMap.get(id);
    }

}

package com.sid.library.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Value("${app.greeting}")
    private String msg;

    @GetMapping
    public ResponseEntity getAllBooks() {
        return new ResponseEntity(Arrays.asList(new Book(1, "Life of cat", "Vivaan Behera"),new Book(2, "Life of dog", "Siddhartha Behera")), HttpStatus.OK);
    }
    @GetMapping(path = "/msg")
    public ResponseEntity getAuthorMessage() {
        return new ResponseEntity(msg, HttpStatus.OK);
    }



}

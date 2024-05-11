package com.sid.library.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Log4j2
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

        Random random = new Random();
        // Define minimum and maximum delay in milliseconds
        int minDelay = 1000; // 1 second
        int maxDelay = 5000; // 5 seconds

        int randomDelay = random.nextInt(maxDelay - minDelay + 1) + minDelay;
        log.info("Simulating work with random delay of " + randomDelay + " milliseconds");
        try {
            Thread.sleep(randomDelay);
        } catch (InterruptedException e) {
            log.error("InterruptedException",e);
        }
        log.info("Work finished!");

        return new ResponseEntity(msg, HttpStatus.OK);
    }



}

package com.sid.library.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Log4j2
@RestController
@RequestMapping("/api/books")
public class BookController {

    @Value("${app.greeting}")
    private String msg;

    @Value("${app.minScale:1000}")
    private Integer minScale;

    @Value("${app.minScale:5000}")
    private Integer maxScale;

    @GetMapping
    public ResponseEntity getAllBooks() {
        return new ResponseEntity(Arrays.asList(new Book(1, "Life of cat", "Vivaan Behera"),new Book(2, "Life of dog", "Siddhartha Behera")), HttpStatus.OK);
    }
    @GetMapping(path = "/msg")
    public ResponseEntity getAuthorMessage() {

        Random random = new Random();

        int randomScale = random.nextInt(maxScale - minScale + 1) + minScale;
        BigDecimal bigNumber = new BigDecimal(Math.PI).setScale(randomScale);
        log.info("Simulating CPU workload with large number calculations (scale: " + randomScale + ")");

        // Perform complex calculations on bigNumber (example: square root)
        BigDecimal squareRoot = bigNumber.sqrt(MathContext.DECIMAL32);
        log.info("CPU workload finished!");

        return new ResponseEntity(msg, HttpStatus.OK);
    }



}

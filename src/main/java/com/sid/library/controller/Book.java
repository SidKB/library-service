package com.sid.library.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    //@Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    //@Column(nullable = false, unique = true)
    private String title;

    //@Column(nullable = false)
    private String author;
}

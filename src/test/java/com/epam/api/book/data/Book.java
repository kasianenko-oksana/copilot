package com.epam.api.book.data;

import lombok.Data;

@Data
public class Book {
    private String isbn;
    private String title;
    private String subTitle;
    private String author;
    private String publisher;
    private int pages;
    private String description;
    private String website;
}

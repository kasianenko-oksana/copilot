package com.epam.api.book.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
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

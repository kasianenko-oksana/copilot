package com.epam.api.book.client;

import com.epam.api.book.data.Book;

import java.util.List;

public interface BookClient {

    List<Book> getBooks();

    Book updateBookByIsbn(String isbn, Book book);
}

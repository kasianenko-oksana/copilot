package com.epam.api.book.client;

import com.epam.api.book.data.Book;
import com.epam.api.book.data.BookList;
import com.epam.api.data.HttpRequest;
import com.epam.api.rest.HttpRequestExecutor;
import com.epam.api.rest.HttpRequestValidator;
import com.epam.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import lombok.var;

import java.util.List;
import java.util.Map;

import static java.net.HttpURLConnection.HTTP_OK;

@Slf4j
public class BookRestClient implements BookClient {

    private static final String GET_BOOK_PATH = "/v1/Books";
    private static final String PUT_BOOK_PATH = "/v1/Books/{isbn}";
    private final String url;
    private final HttpRequestExecutor httpRequestExecutor;
    private final HttpRequestValidator httpRequestValidator;
    private final JsonUtils jsonUtils;

    public BookRestClient(HttpRequestExecutor httpRequestExecutor,
                          HttpRequestValidator httpRequestValidator,
                          JsonUtils jsonUtils,
                          String url) {
        this.url = url;
        this.httpRequestExecutor = httpRequestExecutor;
        this.httpRequestValidator = httpRequestValidator;
        this.jsonUtils = jsonUtils;
    }

    @Override
    public List<Book> getBooks() {
        var httpRequest = HttpRequest.builder()
                .url(url)
                .path(GET_BOOK_PATH)
                .headers(Map.of("Accept", "application/json"))
                .build();
        var response = httpRequestExecutor.get(httpRequest);
        httpRequestValidator.validate(response, HTTP_OK);
        return response.getBody().as(BookList.class).getBooks();
    }

    @Override
    public Book updateBookByIsbn(String isbn, Book book) {
        var body = jsonUtils.objectToJsonString(book);
        var httpRequest = HttpRequest.builder()
                .url(url)
                .path(PUT_BOOK_PATH)
                .body(body)
                .headers(Map.of("Accept", "application/json"))
                .build();
        var response = httpRequestExecutor.put(httpRequest, isbn);
        httpRequestValidator.validate(response, HTTP_OK);
        return response.getBody().as(Book.class);
    }

}

package com.epam.api.book.test;

import com.epam.api.book.client.BookRestClient;
import com.epam.api.rest.HttpRequestExecutor;
import com.epam.api.rest.HttpRequestValidator;
import com.epam.utils.JsonUtils;
import com.epam.utils.PropertiesUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.var;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BookTest {

    private final BookRestClient bookRestClient = new BookRestClient(
            new HttpRequestExecutor(),
            new HttpRequestValidator(),
            new JsonUtils(new ObjectMapper()),
            PropertiesUtils.readPropertyFromFile("dev.properties", "url"));

    /**
     * Test Book service
     */
    @Test
    public void testGetBooks() {
        var books = bookRestClient.getBooks();
        Assert.assertFalse(books.isEmpty());
    }
}

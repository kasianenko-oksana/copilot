package com.epam.api.rest;

import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

public class HttpRequestValidator {

    public void validate(Response response, int expectedStatusCode) {
        response.then().statusCode(expectedStatusCode);
    }
}
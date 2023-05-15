package com.epam.api.rest;

import com.epam.api.data.HttpRequest;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.PrintStream;

public class HttpRequestExecutor {

    public Response post(HttpRequest request) {
        return configRestRequest(request)
                .headers(request.getHeaders())
                .body(request.getBody())
                .post();
    }

    public Response get(HttpRequest request, Object... params) {
        return configRestRequest(request)
                .headers(request.getHeaders())
                .when()
                .get(request.getPath(), params);
    }

    public <T> Response put(HttpRequest request, Object... pathParams) {
        return configRestRequest(request)
                .headers(request.getHeaders())
                .body(request.getBody())
                .put(request.getPath(), pathParams);
    }

    public <T> Response patch(HttpRequest request, Object... pathParams) {
        return configRestRequest(request)
                .headers(request.getHeaders())
                .body(request.getBody())
                .patch(request.getPath(), pathParams);
    }

    private RequestSpecification configRestRequest(HttpRequest request) {
        return RestAssured
                .given()
                .log().all()
                .relaxedHTTPSValidation()
                .contentType(ContentType.JSON).accept(ContentType.JSON)
                .baseUri(request.getUrl());
    }
}
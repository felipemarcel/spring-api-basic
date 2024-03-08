package org.example.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.api.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest
class ApiApplicationTests {

    private static final String API_ROOT = "http://localhost:8081/api/books";

    private Book createRandomBook() {
        Book book = new Book();
        book.setTitle(randomAlphabetic(10));
        book.setAuthor(randomAlphabetic(15));
        return book;
    }

    private String createBookAsUri(Book book) {
        Response response = RestAssured.given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(book)
                .post(API_ROOT);
        return API_ROOT + "/" + response.jsonPath().get("id");
    }

    @Test
    void whenGetAllBooks_thenOK() {
        Response response = RestAssured.get(API_ROOT);

        assertEquals(OK.value(), response.getStatusCode());
    }

    @Test
    void whenGetBooksByTitle_thenOK() {
        Book book = createRandomBook();
        createBookAsUri(book);
        Response response = RestAssured.get(
                API_ROOT + "/title/" + book.getTitle());

        assertEquals(OK.value(), response.getStatusCode());
        assertFalse(response.as(List.class).isEmpty());
    }

    @Test
    void whenGetCreatedBookById_thenOK() {
        Book book = createRandomBook();
        String location = createBookAsUri(book);
        Response response = RestAssured.get(location);

        assertEquals(OK.value(), response.getStatusCode());
        assertEquals(book.getTitle(), response.jsonPath()
                .get("title"));
    }

    @Test
    void whenGetNotExistBookById_thenNotFound() {
        Response response = RestAssured.get(API_ROOT + "/" + randomNumeric(4));

        assertEquals(NOT_FOUND.value(), response.getStatusCode());
    }
}

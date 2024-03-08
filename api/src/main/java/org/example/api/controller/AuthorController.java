package org.example.api.controller;

import org.example.api.exception.BookNotFoundException;
import org.example.api.model.Author;
import org.example.api.model.Book;
import org.example.api.repository.AuthorRepository;
import org.example.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Author>> findAll() {
        return ok(authorRepository.findAll());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author create(@RequestBody Author author) {
        return authorRepository.save(author);
    }


}

package org.example.api.model;

import jakarta.persistence.*;

import static jakarta.persistence.GenerationType.AUTO;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    private Author author;

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public Book() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
package org.example.api.repository;

import org.example.api.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findByTitle(String title);

    @Query("select b.author.name as author, count(b) as count from Book b group by b.author.name")
    List<AuthorCountBooksProjection> countByAuthor();
}

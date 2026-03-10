package com.alura.literatura.repository;

import com.alura.literatura.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByLanguage(String language);

    @Query("SELECT b FROM Book b WHERE b.author.birthYear <= :year AND (b.author.deathYear IS NULL OR b.author.deathYear >= :year)")
    List<Book> findBooksByAuthorAliveInYear(@Param("year") int year);
}

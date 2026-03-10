package com.alura.literatura.service;

import com.alura.literatura.model.Author;
import com.alura.literatura.model.Book;
import com.alura.literatura.repository.AuthorRepository;
import com.alura.literatura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiteratureService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public List<Book> getBooksByLanguage(String language) {
        return bookRepository.findByLanguage(language);
    }

    public List<Book> getBooksByAuthorAliveInYear(int year) {
        return bookRepository.findBooksByAuthorAliveInYear(year);
    }

    public List<Author> getAuthorsAliveInYear(int year) {
        return authorRepository.findAuthorsAliveInYear(year);
    }
}

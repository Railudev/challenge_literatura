package com.alura.literatura.controller;

import com.alura.literatura.model.Book;
import com.alura.literatura.service.GutendexService;
import com.alura.literatura.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private LiteratureService literatureService;

    @Autowired
    private GutendexService gutendexService;

    @GetMapping
    public List<Book> getAllBooks() {
        return literatureService.getAllBooks();
    }

    @GetMapping("/language/{language}")
    public List<Book> getBooksByLanguage(@PathVariable String language) {
        return literatureService.getBooksByLanguage(language);
    }

    @GetMapping("/author-alive/{year}")
    public List<Book> getBooksByAuthorAliveInYear(@PathVariable int year) {
        return literatureService.getBooksByAuthorAliveInYear(year);
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String query) {
        return gutendexService.searchAndSaveBooks(query);
    }
}

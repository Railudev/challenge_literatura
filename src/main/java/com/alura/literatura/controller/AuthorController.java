package com.alura.literatura.controller;

import com.alura.literatura.model.Author;
import com.alura.literatura.service.LiteratureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private LiteratureService literatureService;

    @GetMapping
    public List<Author> getAllAuthors() {
        return literatureService.getAllAuthors();
    }

    @GetMapping("/alive/{year}")
    public List<Author> getAuthorsAliveInYear(@PathVariable int year) {
        return literatureService.getAuthorsAliveInYear(year);
    }
}

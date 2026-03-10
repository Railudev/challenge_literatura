package com.alura.literatura.service;

import com.alura.literatura.model.*;
import com.alura.literatura.repository.AuthorRepository;
import com.alura.literatura.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class GutendexService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    public List<Book> searchAndSaveBooks(String query) {
        String url = "https://gutendex.com/books/?search=" + query.replace(" ", "+");
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        List<Book> books = new ArrayList<>();
        if (response != null && response.getResults() != null) {
            for (BookDTO dto : response.getResults()) {
                Author author = null;
                if (!dto.getAuthors().isEmpty()) {
                    AuthorDTO adto = dto.getAuthors().get(0);
                    author = authorRepository.findByName(adto.getName()).orElse(null);
                    if (author == null) {
                        author = new Author(adto.getName(), adto.getBirth_year(), adto.getDeath_year());
                        author = authorRepository.save(author);
                    }
                }
                String language = dto.getLanguages().isEmpty() ? "en" : dto.getLanguages().get(0);
                Book book = new Book(dto.getTitle(), author, language, dto.getDownload_count());
                book = bookRepository.save(book);
                books.add(book);
            }
        }
        return books;
    }
}

package com.alura.literatura.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

    @GetMapping("/")
    public String welcome() {
        return "Bienvenido a la API de Literatura. Endpoints disponibles:\n" +
               "- GET /books: Lista todos los libros\n" +
               "- GET /books/search?query=...: Busca libros en Gutendex\n" +
               "- GET /books/language/{lang}: Filtra libros por idioma\n" +
               "- GET /books/author-alive/{year}: Libros de autores vivos en ese año\n" +
               "- GET /authors: Lista todos los autores\n" +
               "- GET /authors/alive/{year}: Autores vivos en ese año";
    }
}

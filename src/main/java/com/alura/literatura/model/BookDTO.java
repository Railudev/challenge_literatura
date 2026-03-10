package com.alura.literatura.model;

import java.util.List;

public class BookDTO {
    private String title;
    private List<AuthorDTO> authors;
    private List<String> languages;
    private int download_count;

    public BookDTO() {}

    // Getters and Setters
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public List<AuthorDTO> getAuthors() { return authors; }
    public void setAuthors(List<AuthorDTO> authors) { this.authors = authors; }
    public List<String> getLanguages() { return languages; }
    public void setLanguages(List<String> languages) { this.languages = languages; }
    public int getDownload_count() { return download_count; }
    public void setDownload_count(int download_count) { this.download_count = download_count; }
}

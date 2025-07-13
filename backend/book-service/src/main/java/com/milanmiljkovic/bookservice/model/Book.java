package com.milanmiljkovic.bookservice.model;

public class Book {

    private String title;
    private String[] author_name;

    public Book(String title, String[] author_name) {
        this.title = title;
        this.author_name = author_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String[] author_name) {
        this.author_name = author_name;
    }
}

package com.milanmiljkovic.bookservice.model;

public class Book {


    private String key;
    private String title;
    private String[] author_name;
    private String cover_i;
    private Edition editions;

    public Book(String key, String title, String[] author_name, String cover_i, Edition editions) {
        this.key = key;
        this.title = title;
        this.author_name = author_name;
        this.cover_i = cover_i;
        this.editions = editions;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
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

    public String getCover_i() {
        return cover_i;
    }

    public void setCover_i(String cover_i) {
        this.cover_i = cover_i;
    }
    
    public Edition getEditions() {
    	return this.editions;
    }
    
    public void setEditions(Edition editions) {
    	this.editions = editions;
    }
}

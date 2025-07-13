package com.milanmiljkovic.bookservice.model;

import java.util.List;

public class SearchResult {

    private int numFound;
    private List<Book> docs;

    public SearchResult(int numFound, List<Book> docs) {
        this.numFound = numFound;
        this.docs = docs;
    }

    public int getNumFound() {
        return numFound;
    }

    public void setNumFound(int numFound) {
        this.numFound = numFound;
    }

    public List<Book> getDocs() {
        return docs;
    }

    public void setDocs(List<Book> docs) {
        this.docs = docs;
    }
}

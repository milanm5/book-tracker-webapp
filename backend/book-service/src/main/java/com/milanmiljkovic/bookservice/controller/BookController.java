package com.milanmiljkovic.bookservice.controller;

import com.milanmiljkovic.bookservice.model.SearchResult;
import com.milanmiljkovic.bookservice.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

	@Autowired
	private BookService bookService;
	
    @GetMapping("search")
    public Mono<SearchResult> search(@RequestParam(name ="q") String searchQuery, @RequestParam int page) {
        return this.bookService.search(searchQuery, page);
    }


}

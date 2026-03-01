package com.milanmiljkovic.bookservice.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.milanmiljkovic.bookservice.model.SearchResult;

import reactor.core.publisher.Mono;

@Service
public class BookService {

	private final WebClient webClient;
	
	public BookService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://openlibrary.org/search.json").build();
	}
	
	public Mono<SearchResult> search(String query, int page) {
		
		return this.webClient.get().uri(uriBuilder -> uriBuilder
				.queryParam("q", query)
				.queryParam("lang", "en")
				.queryParam("fields", "key,cover_i,title,author_name,editions")
				.queryParam("offset", page * 5)
				.queryParam("limit", 5)
				.build()).retrieve().bodyToMono(SearchResult.class);
	}
}

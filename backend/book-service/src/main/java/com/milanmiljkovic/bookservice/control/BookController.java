package com.milanmiljkovic.bookservice.control;

import com.milanmiljkovic.bookservice.model.SearchResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RestController
public class BookController {

    private final WebClient webClient;

    private BookController(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://openlibrary.org/search.json").build();
    }

    @GetMapping("search")
    public Mono<SearchResult> search(@RequestParam(name ="q") String searchQuery) {

        String query = searchQuery.replaceAll(" ", "+");

        return this.webClient.get().uri(uriBuilder -> uriBuilder
                .queryParam("q", query)
                .queryParam("limit", 25)
                .build()).retrieve().bodyToMono(SearchResult.class);
    }


}

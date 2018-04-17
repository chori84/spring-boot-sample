package com.chori.springbootwebflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class BookHandler {

    public Mono<ServerResponse> allBooks(ServerRequest request) {
        Book book1 = new Book();
        book1.setIsbn("1234");
        book1.setTitle("Spring Boot WebFlux");

        Book book2 = new Book();
        book2.setIsbn("2345");
        book2.setTitle("Spring Framework 5");

        Flux<Book> books = Flux.just(book1, book2);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(books, Book.class);
    }
}

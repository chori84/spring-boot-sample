package com.chori.springbootwebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class SpringBootWebfluxApplication {

	@Autowired
	BookHandler bookHandler;

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWebfluxApplication.class, args);
	}

	@Bean
	public RouterFunction<ServerResponse> rount() {
		return route(GET("/book").and(accept(MediaType.APPLICATION_JSON)),
			req -> {
				System.out.println("router function");
				Book book1 = new Book();
				book1.setIsbn("1234");
				book1.setTitle("Spring Boot WebFlux");

				Book book2 = new Book();
				book2.setIsbn("2345");
				book2.setTitle("Spring Framework 5");

				Flux<Book> books = Flux.just(book1, book2);

				return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(books, Book.class);
			});
	}
}

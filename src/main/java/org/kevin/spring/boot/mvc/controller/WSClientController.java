package org.kevin.spring.boot.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@Controller
public class WSClientController {

	private WebClient webClient;
	
	@GetMapping("/testwesclient")
	public Mono<String> testwsclient() {		
		this.webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
		Mono<String> returnVal = this.webClient.get().uri("/greeting").retrieve().bodyToMono(String.class);
		return returnVal;
	}
	

}

package com.example.usuarios;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;


@RestController
@RequestMapping("/usuarios")
public class Controllers {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/")
	public String inicioUsuarios() {
		return "Hola soy el inicio de usuarios";
	}
	
	@GetMapping("/ordenes")
	@CircuitBreaker(name="breaker", fallbackMethod = "fallback")
	@TimeLimiter(name="timeBreaker", fallbackMethod = "fallback")
	public CompletableFuture<String> ordenes() {
		
		return CompletableFuture.supplyAsync(()->{
			return restTemplate.getForObject("lb://ordenes/ordenes/", String.class);
		});
		
	}
	
	public CompletableFuture<String> fallback(Throwable throwable) {
		
		return CompletableFuture.supplyAsync(()->{
			return "Ha pasado demasiado tiempo";
		});
					
	}

}

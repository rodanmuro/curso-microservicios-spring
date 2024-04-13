package com.example.cloudstream;

import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CloudstreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudstreamApplication.class, args);
	}
	
	@Bean
	public Supplier<String> publicador() {
		
		return ()->{
			//System.out.println("Este dato viene del supplier");
			return "Hola mundo";
		};
		
	}
	
	@Bean
	public Function<String, String> funcion(){
		return (s)->{
			return s+" con fecha y hora "+(new Date()).toString();
		};
	}
	
	@Bean
	public Consumer<String> consumidor(){
		return (s)->{
			System.out.println("Soy el consumer y los datos que me envían son "+s);
		};
	}
	
}

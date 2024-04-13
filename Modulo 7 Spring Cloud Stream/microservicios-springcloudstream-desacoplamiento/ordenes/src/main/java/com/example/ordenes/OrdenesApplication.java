package com.example.ordenes;

import java.util.Date;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrdenesApplication {
	
	@Autowired
	OrdenRepo ordenRepo;
	
	@Value("${server.port}")
	private String puerto;

	public static void main(String[] args) {
		SpringApplication.run(OrdenesApplication.class, args);
	}
	
	@Bean
	public Consumer<String> ordenConsumida(){
		return (s)->{
			
			Orden orden = new Orden("carlos", "libro", new Date());
			ordenRepo.save(orden);
			
			System.out.println("Orden consumida en el puerto "+puerto+" de la fecha y hora "+s);
		};
	}

}

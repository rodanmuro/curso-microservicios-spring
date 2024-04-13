package com.example.usuarios;

import java.util.Date;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UsuariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosApplication.class, args);
	}
	
	@Bean
	public Supplier<String> enviarOrden(){
		return ()->{
			String orden = "Enviando la orden con fecha y hora "+(new Date()).toString(); 
			//System.out.println(orden);
			return orden;
		};
	}

}

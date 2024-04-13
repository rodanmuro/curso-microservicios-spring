package com.example.ordenes;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes")
public class OrdenesControllers {

	@Value("${server.port}")
	String puerto;
	
	@GetMapping("/")
	public String inicio() {
		return "Hola soy el inicio de Órdenes desde el puerto "+puerto;
	}
	
	@GetMapping("/ordenes")
	public String ordenes(@RequestParam String usuario) {
		return "Hola soy el inicio de órdenes y te saludo usuario " +usuario;
	}
	

}

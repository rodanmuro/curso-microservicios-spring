package com.example.carrito;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllers {
	
	@Value("${soyunavariable}")
	private String soyUnaVariable;
	
	@GetMapping("/")
	public String inicio() {
		return "Hola "+soyUnaVariable+" soy el inicio carrito";
	}

}

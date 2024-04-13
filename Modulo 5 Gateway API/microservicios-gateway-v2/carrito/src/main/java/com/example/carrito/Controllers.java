package com.example.carrito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrito")
public class Controllers {
	
	@GetMapping("/iniciocarrito")
	public String inicioCarrito(@RequestParam String valor) {
		return "Hola soy inicio carrito "+valor;
	}
	
	

}

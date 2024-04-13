package com.example.carrito;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carrito")
public class Controllers {
	
	@GetMapping("/")
	public String inicioCarrito() {
		return "Hola soy el inicio del microservicio carrito";
	}

}

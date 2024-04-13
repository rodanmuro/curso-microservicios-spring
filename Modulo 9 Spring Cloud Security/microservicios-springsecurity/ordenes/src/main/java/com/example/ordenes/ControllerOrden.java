package com.example.ordenes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes")
public class ControllerOrden {
	
	@GetMapping("/")
	public String inicioOrdenes() {
		return "Hola, soy inicio de órdenes";
	}

}

package com.example.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/usuario")
public class Controllers {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String inicioUsuario() {
		return "Hola soy el inicio del microservicio usuario";
	}
	
	@GetMapping("/llamandocarrito")
	public String llamandoCarrito() {
		
		return restTemplate.getForObject("http://carrito/carrito/", String.class);
		
	}

}

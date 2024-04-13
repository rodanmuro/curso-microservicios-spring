package com.example.clienteuno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/clienteuno")
public class Controllers {
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/")
	public String inicio() {
		return "Hola soy el inicio del cliente uno";
	}
	
	@GetMapping("/llamandoalclientedos")
	public String llamandoAlClienteDos() {
		
		return restTemplate.getForObject("lb://clientedos/clientedos/", String.class);
		
	}

}

package com.example.clientedos;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientedos")
public class Controllers {
	
	@Value("${server.port}")
	private String serverPort;
	
	@GetMapping("/")
	public String inicio() {
		return "Hola soy el inicio del cliente dos desde el puerto "+serverPort;
	}

}

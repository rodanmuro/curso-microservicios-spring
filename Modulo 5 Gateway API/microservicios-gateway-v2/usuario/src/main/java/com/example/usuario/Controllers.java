package com.example.usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class Controllers {
	
	@GetMapping("/iniciousuario")
	public String inicioUsuario() {
		return "Hola soy el inicio de usuario";
	}

}

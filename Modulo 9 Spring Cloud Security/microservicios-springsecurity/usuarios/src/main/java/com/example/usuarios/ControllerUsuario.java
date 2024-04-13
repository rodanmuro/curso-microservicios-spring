package com.example.usuarios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {
	
	@GetMapping("/")
	public String inicioUsuarios() {
		return "Hola, soy inicio usuarios";
	}

}

package com.example.demodocker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/demodocker")
public class DockerControllers {
	
	@GetMapping("/")
	public String inicio() {
		return "Hola, soy el inicio de demodocker";
	}

}

package com.example.orden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orden")
public class OrdenController {
	
	@Autowired
	OrdenService ordenService;
	
	@GetMapping("/")
	public String inicioOrden() {
		return "Hola, soy el inicio del microservicio orden";
	}
	
	@PostMapping("/orden")
	public ResponseEntity<Orden> crearOrden(@RequestBody OrdenDTO ordenDTO) {
		
		Orden ordenGuardada = ordenService.guardarOrden(ordenDTO);
		
		return new ResponseEntity<Orden>(ordenGuardada, HttpStatus.CREATED);
		
	}

}

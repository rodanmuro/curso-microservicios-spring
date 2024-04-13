package com.example.ordenes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes")
public class Controllers {
	
	@GetMapping("/")
	public String inicioOrdenes() throws InterruptedException  {
		Thread.sleep(6000);
		
		return "Luego de 5 segundos el inicio de órdenes responde";
	}

}

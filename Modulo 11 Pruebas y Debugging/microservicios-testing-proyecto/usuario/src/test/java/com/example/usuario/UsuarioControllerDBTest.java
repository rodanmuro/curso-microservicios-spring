package com.example.usuario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class UsuarioControllerDBTest {
	
	@Autowired
	WebTestClient webTestClient;
	
	@Test
	void iniciandoTest() {
		
	}
	
	@Test
	void testGuardarUsuario() {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setNombre("Carlos");
		usuarioDTO.setFechaNacimiento("01/01/2020");
		
		webTestClient.post().uri("/usuario/usuario")
		.contentType(MediaType.APPLICATION_JSON)
		.bodyValue(usuarioDTO)
		.exchange()
		.expectBody()
		.jsonPath("$.fechaNacimiento").isEqualTo("2020-01-01");	
	}
	
	@Test
	void testCrearOrden() {
		
		webTestClient.get().uri("/usuario/crear-orden")
        .exchange()
        .expectStatus().isCreated();
	}
	
	

}

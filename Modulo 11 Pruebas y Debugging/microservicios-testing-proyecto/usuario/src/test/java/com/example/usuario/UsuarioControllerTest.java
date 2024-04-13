package com.example.usuario;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

@WebFluxTest(UsuarioController.class)
public class UsuarioControllerTest {
	
	@Autowired
	WebTestClient webTestClient;
	
	@MockBean
	UsuarioService usuarioService;
	
	@Test
	void testInicioUsuario() {
		
		webTestClient
		.get()
		.uri("/usuario/")
		.exchange()
		.expectStatus().isOk()
		.expectBody(String.class).isEqualTo("Hola, soy el inicio usuario");
		
	}
	
	@Test
	void testGuardarUsuario() {
		UsuarioDTO usuarioDTO = new UsuarioDTO("Carlos", "22/12/2020");
		
		Usuario usuarioGuardado = new Usuario();
		usuarioGuardado.setId(1);
		usuarioGuardado.setNombre(usuarioDTO.getNombre());
		usuarioGuardado.setFechaNacimiento(LocalDate.parse(usuarioDTO.getFechaNacimiento(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
		when(usuarioService.guardarUsuario(any(Usuario.class))).thenReturn(usuarioGuardado);
		
		webTestClient.post().uri("/usuario/usuario")
		.bodyValue(usuarioDTO)
		.exchange()
		.expectStatus().isCreated()
		.expectBody()
		.jsonPath("$.id").isNotEmpty();
		
		
	}

}

package com.example.usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	WebClient.Builder webClient;

	@GetMapping("/")
	public String inicioUsuario() {
		return "Hola, soy el inicio usuario";
	}

	@PostMapping("/usuario")
	public ResponseEntity<Usuario> guardarUsuario(@RequestBody UsuarioDTO usuarioDTO) {

		LocalDate fechaNacimiento = LocalDate.parse(usuarioDTO.getFechaNacimiento(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		Usuario usuario = new Usuario();
		usuario.setNombre(usuarioDTO.getNombre());
		usuario.setFechaNacimiento(fechaNacimiento);

		Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);

		return new ResponseEntity<Usuario>(usuarioGuardado, HttpStatus.CREATED);

	}

	@GetMapping("/crear-orden")
	public Mono<ResponseEntity<String>> crearOrden() {

		// JSON request body
		String jsonRequestBody = "{\"idUsuario\": 1, \"nombreItem\": \"libros\" , \"cantidad\": 3, \"precioUnidad\":4000 }";

		return webClient.build().post().uri("http://orden/orden/orden")
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromValue(jsonRequestBody)).retrieve().toEntity(String.class);

	}

}

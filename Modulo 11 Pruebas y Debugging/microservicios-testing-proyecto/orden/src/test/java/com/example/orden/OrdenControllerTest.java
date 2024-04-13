package com.example.orden;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@AutoConfigureWebTestClient
public class OrdenControllerTest {
	
	@Autowired
	WebTestClient webTestClient;
	
	@Test
	void testGuardarOrden() {
		
		OrdenDTO ordenDTO = new OrdenDTO();
		ordenDTO.setIdUsuario(1);
		ordenDTO.setNombreItem("libros");
		ordenDTO.setCantidad(4);
		ordenDTO.setPrecioUnidad(3000f);
		
		webTestClient.post().uri("/orden/orden")
		.contentType(MediaType.APPLICATION_JSON)
		.bodyValue(ordenDTO)
		.exchange()
		.expectStatus().isCreated()
		.returnResult(Orden.class)
		.getResponseBody()
		.subscribe(responseBody->System.out.println(responseBody));
		
	}

}

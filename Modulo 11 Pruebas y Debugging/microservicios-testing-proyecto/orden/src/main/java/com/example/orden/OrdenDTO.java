package com.example.orden;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDTO {
	
	private Integer idUsuario;
	private String nombreItem;
	private Integer cantidad;
	private Float precioUnidad;

}

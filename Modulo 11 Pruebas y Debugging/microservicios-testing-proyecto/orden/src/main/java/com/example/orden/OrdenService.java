package com.example.orden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdenService {
	
	@Autowired
	OrdenRepository ordenRepository;
	
	public Orden guardarOrden(OrdenDTO ordenDTO) {
		
		Orden orden = new Orden();
		orden.setIdUsuario(ordenDTO.getIdUsuario());
		orden.setNombreItem(ordenDTO.getNombreItem());
		orden.setCantidad(ordenDTO.getCantidad());
		orden.setPrecioUnidad(ordenDTO.getPrecioUnidad());
		
		return ordenRepository.save(orden);
	}

}

package com.example.ordenes;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orden {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String usuario;
	private String producto;
	private Date timestamp;
	
	public Orden(String usuario, String producto, Date timestamp) {
		this.usuario = usuario;
		this.producto = producto;
		this.timestamp = timestamp;
	}

}

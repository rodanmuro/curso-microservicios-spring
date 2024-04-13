package com.example.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	
	public Usuario guardarUsuario(Usuario usuario) {
		
		return usuarioRepository.save(usuario);
		
	}

}

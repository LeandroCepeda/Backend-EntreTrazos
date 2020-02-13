package com.integrador.ProyectoIntegradorV1.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.integrador.ProyectoIntegradorV1.entidades.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Integer> {
	
	Usuario findByEmail(String email);

}

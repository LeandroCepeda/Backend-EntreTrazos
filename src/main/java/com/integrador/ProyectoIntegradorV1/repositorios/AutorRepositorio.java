package com.integrador.ProyectoIntegradorV1.repositorios;


import org.springframework.data.repository.CrudRepository;

import com.integrador.ProyectoIntegradorV1.entidades.Autor;

public interface AutorRepositorio extends CrudRepository<Autor, Integer> {
	
	Autor findByNombre(String nombre);

}

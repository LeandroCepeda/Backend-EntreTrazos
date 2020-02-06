package com.integrador.ProyectoIntegradorV1.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.integrador.ProyectoIntegradorV1.entidades.Libro;

public interface LibroRepositorio extends CrudRepository<Libro, Integer> {
	
	Libro findByTitulo(String titulo);
	
}

package com.integrador.ProyectoIntegradorV1.servicios;

import java.util.List;

import com.integrador.ProyectoIntegradorV1.entidades.Libro;

public interface ILibroServicio  {
	
	public List<Libro> findAll() throws Exception;
	
	public Libro findById(int id) throws Exception;
	
	public Libro save(Libro libro) throws Exception;
	
	public Libro update(int id, Libro libro) throws Exception;
	
	public boolean delete(int id) throws Exception;

}

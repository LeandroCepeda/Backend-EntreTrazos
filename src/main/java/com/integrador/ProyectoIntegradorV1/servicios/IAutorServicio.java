package com.integrador.ProyectoIntegradorV1.servicios;

import java.util.List;

import com.integrador.ProyectoIntegradorV1.entidades.Autor;

public interface IAutorServicio {
	
	public List<Autor> findAll() throws Exception;
	
	public Autor findById(int id) throws Exception;
	
	public Autor save(Autor autor) throws Exception;
	
	public Autor update(int id, Autor autor) throws Exception;
	
	public boolean delete(int id) throws Exception;
	
	public Autor findByNombre(String nombre) throws Exception;

}

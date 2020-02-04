package com.integrador.ProyectoIntegradorV1.servicios;

import java.util.List;

import com.integrador.ProyectoIntegradorV1.entidades.Categoria;

public interface ICategoriaServicio {
	
	public List<Categoria> findAll() throws Exception;
	
	public Categoria findById(int id) throws Exception;
	
	public Categoria save(Categoria categoria) throws Exception;
	
	public Categoria update(int id, Categoria categoria) throws Exception;
	
	public boolean delete(int id) throws Exception;
	
	public Categoria findByNombre(String nombre) throws Exception;

}

package com.integrador.ProyectoIntegradorV1.servicios;

import java.util.List;

import com.integrador.ProyectoIntegradorV1.entidades.Imagen;

public interface IImagenServicio {
	
public List<Imagen> findAll() throws Exception;
	
	public Imagen findById(int id) throws Exception;
	
	public Imagen save(Imagen imagen) throws Exception;
	
	public Imagen update(int id, Imagen imagen) throws Exception;
	
	public boolean delete(int id) throws Exception;

}

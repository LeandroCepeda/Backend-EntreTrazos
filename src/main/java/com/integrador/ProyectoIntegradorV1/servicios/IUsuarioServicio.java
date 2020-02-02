package com.integrador.ProyectoIntegradorV1.servicios;

import java.util.List;

import com.integrador.ProyectoIntegradorV1.entidades.Usuario;

public interface IUsuarioServicio {
	
public List<Usuario> findAll() throws Exception;
	
	public Usuario findById(int id) throws Exception;
	
	public Usuario save(Usuario usuario) throws Exception;
	
	public Usuario update(int id, Usuario usuario) throws Exception;
	
	public boolean delete(int id) throws Exception;

}

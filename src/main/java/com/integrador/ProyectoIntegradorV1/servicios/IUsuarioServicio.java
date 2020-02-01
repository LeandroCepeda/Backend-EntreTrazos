package com.integrador.ProyectoIntegradorV1.servicios;

import java.util.List;

import com.integrador.ProyectoIntegradorV1.entidades.Usuario;

public interface IUsuarioServicio {
	
	public List<Usuario> generarLista();
	
	public Usuario buscarUsuarioPorId(int id, List<Usuario> usuario);

}

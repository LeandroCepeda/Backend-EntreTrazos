package com.integrador.ProyectoIntegradorV1.servicios;

import java.util.List;

import com.integrador.ProyectoIntegradorV1.entidades.Categoria;

public interface ICategoriaServicio {
	
	public List<Categoria> generarLista();
	
	public Categoria buscarCategoriaPorId(int id, List<Categoria> categorias);

}

package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Categoria;
import com.integrador.ProyectoIntegradorV1.servicios.ICategoriaServicio;

@Service("CategoriaServicio")
public class CategoriaServicio implements ICategoriaServicio {

	@Override
	public List<Categoria> generarLista() {
		List<Categoria> categorias = new ArrayList<>();
		
		for (int i = 0; i <= 10 ;i++) {
			Categoria categoria = new Categoria();
			categoria.setId(i);
			categoria.setNombre("Categoria #" +i);		
			categorias.add(categoria);
		}
		return categorias;
	}

	@Override
	public Categoria buscarCategoriaPorId(int id, List<Categoria> categorias) {
		for (Categoria categoria : categorias) {
			if(categoria.getId() == id) {
				return categoria;
			}
			
		}
		return null;
	}

}

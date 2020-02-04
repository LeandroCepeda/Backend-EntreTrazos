package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Categoria;
import com.integrador.ProyectoIntegradorV1.repositorios.CategoriaRepositorio;
import com.integrador.ProyectoIntegradorV1.servicios.ICategoriaServicio;

@Service("CategoriaServicio")
public class CategoriaServicio implements ICategoriaServicio {

	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	@Override
	public List<Categoria> findAll() throws Exception {
		List<Categoria> categorias = new ArrayList<>();
		
		try {
			for (Categoria categoria : categoriaRepositorio.findAll()) {
				categorias.add(categoria);
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return categorias;
	}

	@Override
	public Categoria findById(int id) throws Exception {
		Optional<Categoria> optional = categoriaRepositorio.findById(id);
		
		try {
			Categoria categoria = optional.get();
			return categoria;
		} catch (Exception e) {
			throw new Exception();
		}

	}

	@Override
	public Categoria save(Categoria categoria) throws Exception {
		try {
			categoriaRepositorio.save(categoria);
			return categoria;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Categoria update(int id, Categoria categoria) throws Exception {
		Optional<Categoria> optional = categoriaRepositorio.findById(id);
		Categoria categoriaActualizada = new Categoria();
		
		try {
			categoriaActualizada = optional.get();
			
			if(categoriaRepositorio.existsById(id)) {
				categoriaActualizada.setId(categoria.getId());
				categoriaActualizada.setNombre(categoria.getNombre());
				categoriaRepositorio.save(categoriaActualizada);
				return categoriaActualizada;
				
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}

	}

	@Override
	public boolean delete(int id) throws Exception {
		try {
			if(categoriaRepositorio.existsById(id)) {
				categoriaRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Categoria findByNombre(String nombre) throws Exception {
		return categoriaRepositorio.findByNombre(nombre);
	}

}

package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Autor;
import com.integrador.ProyectoIntegradorV1.repositorios.AutorRepositorio;
import com.integrador.ProyectoIntegradorV1.servicios.IAutorServicio;

@Service("AutorServicio")
public class AutorServicio implements IAutorServicio {
	
	@Autowired
	private AutorRepositorio autorRepositorio;

	@Override
	public List<Autor> findAll() throws Exception {
		List<Autor> autores = new ArrayList<>();
		
		try {
			for (Autor autor : autorRepositorio.findAll()) {
				autores.add(autor);
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return autores;
	}

	@Override
	public Autor findById(int id) throws Exception {
		Optional<Autor> optional = autorRepositorio.findById(id);
		
		try {
			Autor autor = optional.get();
			return autor;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Autor save(Autor autor) throws Exception {
		try {
			autorRepositorio.save(autor);
			return autor;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Autor update(int id, Autor autor) throws Exception {
		Optional<Autor> optional = autorRepositorio.findById(id);
		Autor autorActualizado = new Autor();
		
		try {
			autorActualizado = optional.get();
			
			if(autorRepositorio.existsById(id)) {
				autorActualizado.setId(autor.getId());
				autorActualizado.setNombre(autor.getNombre());
				autorRepositorio.save(autorActualizado);
				return autorActualizado;
				
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
			if(autorRepositorio.existsById(id)) {
				autorRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Autor findByNombre(String nombre) throws Exception {
		return autorRepositorio.findByNombre(nombre);
	}
	
	

}

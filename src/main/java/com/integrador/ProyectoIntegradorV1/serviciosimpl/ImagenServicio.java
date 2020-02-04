package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Imagen;
import com.integrador.ProyectoIntegradorV1.repositorios.ImagenRepositorio;
import com.integrador.ProyectoIntegradorV1.servicios.IImagenServicio;

@Service("ImagenServicio")
public class ImagenServicio implements IImagenServicio {
	
	@Autowired
	private ImagenRepositorio imagenRepositorio;

	@Override
	public List<Imagen> findAll() throws Exception {
		List<Imagen> imagenes = new ArrayList<>();
		
		try {
			for (Imagen imagen : imagenRepositorio.findAll()) {
				imagenes.add(imagen);
			}
		} catch (Exception e) {
			throw new Exception();
		}
		return imagenes;
	}

	@Override
	public Imagen findById(int id) throws Exception {
		Optional<Imagen> optional = imagenRepositorio.findById(id);
		
		try {
			Imagen imagen = optional.get();
			return imagen;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Imagen save(Imagen imagen) throws Exception {
		try {
			imagenRepositorio.save(imagen);
			return imagen;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Imagen update(int id, Imagen imagen) throws Exception {
		Optional<Imagen> optional = imagenRepositorio.findById(id);
		Imagen imagenActualizada = new Imagen();
		
		try {
			imagenActualizada = optional.get();
			
			if(imagenRepositorio.existsById(id)) {
				imagenActualizada.setId(imagen.getId());
				imagenActualizada.setUrl(imagen.getUrl());
				imagenRepositorio.save(imagenActualizada);
				return imagenActualizada;
				
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
			if(imagenRepositorio.existsById(id)) {
				imagenRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception();
		}
	}

}

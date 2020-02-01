package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Libro;
import com.integrador.ProyectoIntegradorV1.repositorios.LibroRepositorio;
import com.integrador.ProyectoIntegradorV1.servicios.ILibroServicio;

@Service("LibroServicio")
public class LibroServicio implements ILibroServicio {
	
	@Autowired
	private LibroRepositorio libroRepositorio;
	
	@Override
	public List<Libro> findAll() throws Exception {
		List<Libro> libros = new ArrayList<>();
		
		try {
			
			for (Libro libro : libroRepositorio.findAll()) {
				libros.add(libro);
			}	
			
			
		} catch (Exception e) {
			throw new Exception();
		}
		
		return libros;
	}

	
	@Override
	public Libro findById(int id) throws Exception {
		Optional<Libro> optional = libroRepositorio.findById(id);
		
		try {
			Libro libro = optional.get();
			return libro;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	
	@Override
	public Libro save(Libro libro) throws Exception {
		
		try {
			libroRepositorio.save(libro);
			return libro;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	@Override
	public Libro update(int id, Libro libro) throws Exception {
		Optional<Libro> optional = libroRepositorio.findById(id);
		
		try {
			Libro libro1 = optional.get();
			
			if(libroRepositorio.existsById(id)) {
				libro1.setId(libro.getId());
				libroRepositorio.save(libro1);
				return libro1;
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
			if(libroRepositorio.existsById(id)) {
				libroRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
	
//	@Override
//	public List<Libro> generarLista() {
//		List<Libro> libros = new ArrayList<>();
//		
//		for (int i = 0; i <= 10; i++) {
//			Libro libro = new Libro();
//			libro.setId(i);
//			libro.setIsbn(1 + i);
//			libro.setPrecio(100 + i);
//			libro.setTitulo("Titulo Libro #" + i);
//			libro.setEstado("Estado Libro #" + i);
//			libros.add(libro);
//		}	
//		
//		return libros;
//	}
//
//	@Override
//	public Libro buscarLibroPorId(int id, List<Libro> libros) {
//		for (Libro libro : libros) {
//			if(libro.getId() == id) {
//				return libro;
//			}
//		}
//		return null;
//	}
	
	
	

}

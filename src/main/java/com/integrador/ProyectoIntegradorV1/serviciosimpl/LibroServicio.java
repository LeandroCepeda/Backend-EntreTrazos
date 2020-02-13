package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Autor;
import com.integrador.ProyectoIntegradorV1.entidades.Categoria;
import com.integrador.ProyectoIntegradorV1.entidades.Libro;
import com.integrador.ProyectoIntegradorV1.repositorios.LibroRepositorio;
import com.integrador.ProyectoIntegradorV1.servicios.IAutorServicio;
import com.integrador.ProyectoIntegradorV1.servicios.ICategoriaServicio;
import com.integrador.ProyectoIntegradorV1.servicios.ILibroServicio;

@Service("LibroServicio")
public class LibroServicio implements ILibroServicio {
	
	@Autowired
	private LibroRepositorio libroRepositorio;
	
	@Autowired
	@Qualifier("AutorServicio")
	private IAutorServicio autorServicio;
	
	@Autowired
	@Qualifier("CategoriaServicio")
	private ICategoriaServicio categoriaServicio;
	
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
	public Libro findByTitulo(String titulo) throws Exception {
		return libroRepositorio.findByTitulo(titulo);
	}
	
	
	@Override
	public List<Libro> findAllByCategory(String categoria) throws Exception {
		try {
			Categoria categoriaLibro = categoriaServicio.findByNombre(categoria);
			List<Libro> librosCategoria = new ArrayList<>();
			
			for (Libro libro : libroRepositorio.findAll()) {
				if(libro.getCategoria().equals(categoriaLibro)) {
					librosCategoria.add(libro);
				}	
			}
			
			return librosCategoria;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	
	@Override
	public Libro save(Libro libro) throws Exception {
		if(findByTitulo(libro.getTitulo()) != null) {
			return null;
		}
		try {
			Autor autor = autorServicio.findByNombre(libro.getAutor().getNombre());
			if(autor != null) {
				libro.setAutor(autor);
			}
			
			Categoria categoria = categoriaServicio.findByNombre(libro.getCategoria().getNombre());
			if(categoria != null) {
				libro.setCategoria(categoria);	 
			}
			
			libroRepositorio.save(libro);
			return libro;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	@Override
	public Libro update(int id, Libro libro) throws Exception {
		Optional<Libro> optional = libroRepositorio.findById(id);
		Libro libroActualizado = new Libro();
		
		try {
			libroActualizado = optional.get();
			
			if(libroRepositorio.existsById(id)) {
				libroActualizado.setId(libro.getId());
				libroActualizado.setIsbn(libro.getIsbn());
				libroActualizado.setTitulo(libro.getTitulo());
				libroActualizado.setEditorial(libro.getEditorial());
				libroActualizado.setPrecio(libro.getPrecio());
				libroActualizado.setEstado(libro.getEstado());
//				libroActualizado.setAutor(libro.getAutor());
//				libroActualizado.setCategoria(libro.getCategoria());
				try {
					Autor autor = autorServicio.findByNombre(libro.getAutor().getNombre());
					if(autor != null) {
						libroActualizado.setAutor(autor);	
					} else {
						libroActualizado.setAutor(libro.getAutor());
					}
					
					Categoria categoria = categoriaServicio.findByNombre(libro.getCategoria().getNombre());
					if(categoria != null) {
						libroActualizado.setCategoria(categoria);	 
					} else {
						libroActualizado.setCategoria(libro.getCategoria());
					}
				} catch (Exception e) {
					throw new Exception();
				}
				
				libroActualizado.setImagen(libro.getImagen());
				libroRepositorio.save(libroActualizado);
				return libroActualizado;
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

}

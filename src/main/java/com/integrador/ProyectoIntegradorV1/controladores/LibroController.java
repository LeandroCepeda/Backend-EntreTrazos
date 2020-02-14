package com.integrador.ProyectoIntegradorV1.controladores;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.integrador.ProyectoIntegradorV1.entidades.Libro;
import com.integrador.ProyectoIntegradorV1.servicios.IAutorServicio;
import com.integrador.ProyectoIntegradorV1.servicios.ICategoriaServicio;
import com.integrador.ProyectoIntegradorV1.servicios.ILibroServicio;

@Controller
@RequestMapping(path ="/libro")
public class LibroController {
	
	@Autowired
	@Qualifier("LibroServicio")
	private ILibroServicio libroServicio;
	
	@Autowired
	@Qualifier("AutorServicio")
	private IAutorServicio autorServicio;
	
	@Autowired
	@Qualifier("CategoriaServicio")
	private ICategoriaServicio categoriaServicio;

	
	@GetMapping(value="/agregar")
	public String agregarLibro(Model model) {
		model.addAttribute("libro", new Libro());
		
		return "libro/agregar-libro";
	}
	
	@PostMapping(value = "/agregar")
	public String guardarProducto(@ModelAttribute @Valid Libro libro, BindingResult bindingResult,RedirectAttributes redir) {
		if(bindingResult.hasErrors()) {
			return "libro/agregar-libro";
		}
		
		try {
			if(libroServicio.save(libro) != null) {
				redir.addFlashAttribute("mensaje", "El producto se agrego correctamente").addFlashAttribute("clase", "success");
			} else {
				redir.addFlashAttribute("mensaje", "Ya existe un titulo con ese nombre").addFlashAttribute("clase", "danger");;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "redirect:/libro/agregar";
	}
	
	@GetMapping(value="/lista")
	public String mostrarLibros(Model model) {
		
		try {
			model.addAttribute("libros", libroServicio.findAll());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "libro/mostrar-libros";
		
	}
	
	@GetMapping(value="/editar/{id}")
	public String editarLibro(@PathVariable int id, Model model) {
		try {
			model.addAttribute("libro", libroServicio.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "libro/editar-libro";
		
	}
	
	@PostMapping(value="/editar/{id}")
	public String actualizarLibro(@ModelAttribute @Valid Libro libro, BindingResult bindingResult, @PathVariable int id, RedirectAttributes redir) {
		if(bindingResult.hasErrors()) {
			return "libro/editar-libro";
		}
	
		try {
			libroServicio.update(id,libro);
			redir.addFlashAttribute("mensaje", "El libro se editó correctamente");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/libro/lista";	
	}
	
	@PostMapping(value="/eliminar")
	public String eliminarLibro(@ModelAttribute Libro libro, RedirectAttributes redir) {
		
		try {
			libroServicio.delete(libro.getId());
			redir.addFlashAttribute("mensaje", "Eliminado correctamente").addFlashAttribute("clase", "success");
		} catch (Exception e) {
			redir.addFlashAttribute("mensaje", "No se pudo eliminar").addFlashAttribute("clase", "danger");
			e.printStackTrace();
		}
		
		return "redirect:/libro/lista";
	}
	

}

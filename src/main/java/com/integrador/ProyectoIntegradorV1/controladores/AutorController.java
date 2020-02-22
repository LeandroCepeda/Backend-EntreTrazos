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

import com.integrador.ProyectoIntegradorV1.entidades.Autor;
import com.integrador.ProyectoIntegradorV1.servicios.IAutorServicio;

@Controller
@RequestMapping(value="/autor")
public class AutorController {
	
	@Autowired
	@Qualifier("AutorServicio")
	private IAutorServicio autorServicio;
	
	
	@GetMapping(value="/agregar")
	public String agregarAutor(Model model) {
		model.addAttribute("autor", new Autor());
		
		return "autor/agregar-autor";
	}
	
	
	@PostMapping(value ="/agregar")
	public String guardarAutor(@ModelAttribute @Valid Autor autor, BindingResult bindingResult, RedirectAttributes redir) {
		if(bindingResult.hasErrors()) {
			return "autor/agregar-autor";
		}
		
		try {
			autorServicio.save(autor);
			redir.addFlashAttribute("mensaje", "El autor se agrego correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/autor/agregar";
		
	}
	
	@GetMapping(value="/lista")
	public String mostrarAutores(Model model) {
		try {
			model.addAttribute("autores", autorServicio.findAll());
		} catch (Exception e) {
			
		}
		
		return "autor/mostrar-autores";
	}
	
	
	@GetMapping(value="/editar/{id}")
	public String editarAutor(@PathVariable int id, Model model) {
		try {
			model.addAttribute("autor", autorServicio.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "autor/editar-autor";
	}
	
	
	@PostMapping(value="/editar/{id}")
	public String actualizarAutor(@ModelAttribute @Valid Autor autor,@PathVariable int id, BindingResult bindingResult, RedirectAttributes redir) {
		if(bindingResult.hasErrors()) {
			return "autor/editar-autor";
		}
		
		try {
			autorServicio.update(id, autor);
			redir.addFlashAttribute("mensaje", "El autor se editó correctamente");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/autor/lista";
	}
	
	@PostMapping(value="/eliminar")
	public String eliminarAutor(@ModelAttribute Autor autor, RedirectAttributes redir) {
		
		try {
			autorServicio.delete(autor.getId());
			redir.addFlashAttribute("mensaje", "Eliminado correctamente");
		} catch (Exception e) {
			e.printStackTrace();
			
		}
		redir.addFlashAttribute("mensaje", "No puede eliminar el autor porque tiene libros asociados");
		return "redirect:/autor/lista";
	}

}

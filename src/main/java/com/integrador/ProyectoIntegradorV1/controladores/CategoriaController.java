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

import com.integrador.ProyectoIntegradorV1.entidades.Categoria;
import com.integrador.ProyectoIntegradorV1.servicios.ICategoriaServicio;

@Controller
@RequestMapping(value="/categoria")
public class CategoriaController {
	
	@Autowired
	@Qualifier("CategoriaServicio")
	private ICategoriaServicio categoriaServicio;
	
	
	@GetMapping(value="/agregar")
	public String agregarCategoria(Model model) {
		model.addAttribute("categoria", new Categoria());
		
		return "categoria/agregar-categoria";
	}
	
	
	@PostMapping(value ="/agregar")
	public String guardarCategoria(@ModelAttribute @Valid Categoria categoria, BindingResult bindingResult, RedirectAttributes redir) {
		if(bindingResult.hasErrors()) {
			return "categoria/agregar-categoria";
		}
		
		try {
			categoriaServicio.save(categoria);
			redir.addFlashAttribute("mensaje", "La categoría se agrego correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/categoria/agregar";
		
	}
	
	@GetMapping(value="/lista")
	public String mostrarCategorias(Model model) {
		try {
			model.addAttribute("categorias", categoriaServicio.findAll());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "categoria/mostrar-categorias";
	}
	
	
	@GetMapping(value="/editar/{id}")
	public String editarCategoria(@PathVariable int id, Model model) {
		try {
			model.addAttribute("categoria", categoriaServicio.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "categoria/editar-categoria";
	}
	
	
	@PostMapping(value="/editar/{id}")
	public String actualizarCategoria(@ModelAttribute @Valid Categoria categoria,@PathVariable int id, BindingResult bindingResult, RedirectAttributes redir) {
		if(bindingResult.hasErrors()) {
			return "categoria/editar-categoria";
		}
		
		try {
			categoriaServicio.update(id, categoria);
			redir.addFlashAttribute("mensaje", "El libro se editó correctamente");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/categoria/lista";	
	}
	
	@PostMapping(value="/eliminar")
	public String eliminarCategoria(@ModelAttribute Categoria categoria, RedirectAttributes redir) {
		
		try {
			categoriaServicio.delete(categoria.getId());
			redir.addFlashAttribute("mensaje", "Eliminado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/categoria/lista";
	}

	
}

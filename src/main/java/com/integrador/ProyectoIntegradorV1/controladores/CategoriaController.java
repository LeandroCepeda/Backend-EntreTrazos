package com.integrador.ProyectoIntegradorV1.controladores;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
		
		List<Categoria> categorias = categoriaServicio.generarLista();
		categorias.add(categoria);
		
		redir.addFlashAttribute("mensaje", "La categoria se agrego correctamente");
		return "redirect:/categoria/agregar";
	}
	
	@GetMapping(value="/lista")
	public String mostrarCategorias(Model model) {
		List<Categoria> categorias = categoriaServicio.generarLista();
		
		model.addAttribute("categorias", categorias);
		
		return "categoria/mostrar-categorias";
	}

	
}

package com.integrador.ProyectoIntegradorV1.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.integrador.ProyectoIntegradorV1.entidades.Imagen;
import com.integrador.ProyectoIntegradorV1.servicios.IImagenServicio;

@Controller
@RequestMapping(value="/imagen")
public class ImagenController {
	
	@Autowired
	@Qualifier("ImagenServicio")
	private IImagenServicio imagenServicio;
	
	//CREATE,UPDATE LO HACEMOS DESDE LIBRO(PREGUNTAR) 
	
	@GetMapping(value ="/lista")
	public String mostrarImagenes(Model model) {
		
		try {
			model.addAttribute("imagenes", imagenServicio.findAll());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "imagen/mostrar-imagenes";
	}
	
	
	@PostMapping(value="/eliminar")
	public String eliminarImagen(@ModelAttribute Imagen imagen, RedirectAttributes redir) {
		
		try {
			imagenServicio.delete(imagen.getId());
			redir.addFlashAttribute("mensaje", "Eliminado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/imagen/lista";
	}

}

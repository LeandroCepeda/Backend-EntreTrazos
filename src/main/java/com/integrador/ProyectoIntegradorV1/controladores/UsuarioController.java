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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.integrador.ProyectoIntegradorV1.entidades.Categoria;
import com.integrador.ProyectoIntegradorV1.entidades.Usuario;
import com.integrador.ProyectoIntegradorV1.servicios.IUsuarioServicio;
import com.integrador.ProyectoIntegradorV1.serviciosimpl.UsuarioServicio;

@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("UsuarioServicio")
	private IUsuarioServicio usuarioServicio;
	
	
	@GetMapping(value="/agregar")
	public String agregarUsuario(Model model) {
		model.addAttribute("usuario", new Usuario());
		
		return "usuario/agregar-usuario";
	}
	
	@PostMapping(value = "/agregar")
	public String guardarUsuario(@ModelAttribute @Valid Usuario usuario, BindingResult bindingResult, RedirectAttributes redir) {
		if(bindingResult.hasErrors()) {
			return "usuario/agregar-usuario";
		}
		
		try {
			usuarioServicio.save(usuario);
			redir.addFlashAttribute("mensaje", "El usuario se agrego correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/usuario/agregar";
	}
	
	
	@GetMapping(value = "/lista")
	public String mostrarUsuarios(Model model) {
		try {
			model.addAttribute("usuarios", usuarioServicio.findAll());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "usuario/mostrar-usuarios";
	}
	
	@GetMapping(value="/editar/{id}")
	public String editarUsuario(@PathVariable int id, Model model) {
		try {
			model.addAttribute("usuario", usuarioServicio.findById(id));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "usuario/editar-usuario";
	}
	
	
	@PostMapping(value="/editar/{id}")
	public String actualizarUsuario(@ModelAttribute @Valid Usuario usuario,@PathVariable int id, BindingResult bindingResult, RedirectAttributes redir) {
		if(bindingResult.hasErrors()) {
			return "usuario/editar-usuario";
		}
		
		try {
			usuarioServicio.update(id, usuario);
			redir.addFlashAttribute("mensaje", "El usuario se editó correctamente");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/usuario/lista";	
	}
	
	@PostMapping(value="/eliminar")
	public String eliminarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redir) {
		
		try {
			usuarioServicio.delete(usuario.getId());
			redir.addFlashAttribute("mensaje", "Eliminado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/usuario/lista";
	}
	

}

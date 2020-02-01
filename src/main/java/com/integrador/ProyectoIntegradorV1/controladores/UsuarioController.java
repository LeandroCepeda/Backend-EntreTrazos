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

import com.integrador.ProyectoIntegradorV1.entidades.Usuario;
import com.integrador.ProyectoIntegradorV1.servicios.IUsuarioServicio;

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
		
		List<Usuario> usuarios = usuarioServicio.generarLista();
		usuarios.add(usuario);
		redir.addFlashAttribute("mensaje", "El usuario se agrego correctamente");
		return "redirect:/usuario/agregar";
	}
	
	@GetMapping(value = "/lista")
	public String mostrarUsuarios(Model model) {
		List<Usuario> usuarios = usuarioServicio.generarLista();
		model.addAttribute("usuarios", usuarios);
		
		return "usuario/mostrar-usuarios";
	}

}

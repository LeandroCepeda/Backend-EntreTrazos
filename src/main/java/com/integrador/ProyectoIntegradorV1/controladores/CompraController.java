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

import com.integrador.ProyectoIntegradorV1.entidades.Compra;
import com.integrador.ProyectoIntegradorV1.servicios.ICompraServicio;

@Controller
@RequestMapping(value="/compra")
public class CompraController {
	
	@Autowired
	@Qualifier("CompraServicio")
	private ICompraServicio compraServicio;
	
	
	@GetMapping(value ="/lista")
	public String mostrarCompras(Model model) {
		
		try {
			model.addAttribute("compras", compraServicio.findAll());
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "compra/mostrar-compras";
	}
	
	
	@PostMapping(value="/eliminar")
	public String eliminarCompra(@ModelAttribute Compra compra, RedirectAttributes redir) {
		
		try {
			compraServicio.delete(compra.getId());
			redir.addFlashAttribute("mensaje", "Eliminado correctamente");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "redirect:/compra/lista";
	}

}

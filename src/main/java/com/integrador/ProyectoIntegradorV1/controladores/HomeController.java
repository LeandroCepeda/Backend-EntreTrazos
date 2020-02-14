package com.integrador.ProyectoIntegradorV1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	//PAGINA DE BIENVENIDA
	@GetMapping(value ="")
	public String bienvenido() {
		return "bienvenido";
	}
	
}

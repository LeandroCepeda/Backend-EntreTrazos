	package com.integrador.ProyectoIntegradorV1.controladoresRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.ProyectoIntegradorV1.entidades.Categoria;
import com.integrador.ProyectoIntegradorV1.servicios.ICategoriaServicio;

@RestController
@RequestMapping(path = "api/categoria")
public class CategoriaRestController {
	
	@Autowired
	@Qualifier("CategoriaServicio")
	private ICategoriaServicio categoriaServicio;
	
	
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public List<Categoria> getAll() throws Exception {
		
		return ResponseEntity.status(200).body(categoriaServicio.findAll()).getBody();
	}
	
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public Categoria getOne(@PathVariable int id) throws Exception {
		
		return ResponseEntity.status(200).body(categoriaServicio.findById(id)).getBody();
		
	}
	
	@GetMapping("/{nombre}")
	public Categoria getByNombre(@PathVariable String nombre) throws Exception {
		
		return ResponseEntity.status(200).body(categoriaServicio.findByNombre(nombre)).getBody();
	}
	
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity save(@RequestBody Categoria categoria) {
		
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(categoriaServicio.save(categoria));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
						
		}
	}
	
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity update(@RequestBody Categoria categoria, @PathVariable int id) {
		
		try {
			
			
			return ResponseEntity.status(HttpStatus.FOUND).body(categoriaServicio.update(id, categoria));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
						
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity delete(@PathVariable int id) {
		
		try {
			categoriaServicio.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
						
		}
		
	}

}

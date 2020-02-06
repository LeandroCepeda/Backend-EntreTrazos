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

import com.integrador.ProyectoIntegradorV1.entidades.Compra;
import com.integrador.ProyectoIntegradorV1.servicios.ICompraServicio;

@RestController
@RequestMapping(value ="api/compra")
public class CompraRestController {
	
	@Autowired
	@Qualifier("CompraServicio")
	private ICompraServicio compraServicio;
	
	
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public List<Compra> getAll() throws Exception {
		
		return ResponseEntity.status(200).body(compraServicio.findAll()).getBody();
	}
	
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public Compra getOne(@PathVariable int id) throws Exception {
		
		return ResponseEntity.status(200).body(compraServicio.findById(id)).getBody();
		
	}
	
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity save(@RequestBody Compra compra) {
		
		
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(compraServicio.save(compra));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
						
		}
	}
	
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity update(@RequestBody Compra compra, @PathVariable int id) {
		
		try {
			
			
			return ResponseEntity.status(HttpStatus.FOUND).body(compraServicio.update(id, compra));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
						
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity delete(@PathVariable int id) {
		
		try {
			compraServicio.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
						
		}
		
	}

}

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

import com.integrador.ProyectoIntegradorV1.entidades.Usuario;
import com.integrador.ProyectoIntegradorV1.servicios.IUsuarioServicio;

@RestController
@RequestMapping(value ="api/usuario")
public class UsuarioRestController {

	
	@Autowired
	@Qualifier("UsuarioServicio")
	private IUsuarioServicio usuarioServicio;
	
	
	@GetMapping("/")
	@CrossOrigin(origins = "*")
	public List<Usuario> getAll() throws Exception {
		
		return ResponseEntity.status(200).body(usuarioServicio.findAll()).getBody();
	}
	
	
	@GetMapping("/{id}")
	@CrossOrigin(origins = "*")
	public Usuario getOne(@PathVariable int id) throws Exception {
		
		return ResponseEntity.status(200).body(usuarioServicio.findById(id)).getBody();
		
	}
	
	// http://localhost:8080/api/usuario/emailPassword?email=leandro@hotmail.com&password=123
	// http://localhost:8080/api/usuario/emailPassword/leandro@hotmail.com/123/
	@GetMapping("emailPassword/{email}/{password}")
	public ResponseEntity getByEmailAndPassword(@PathVariable String email, @PathVariable String password) throws Exception {
		Usuario usuario = usuarioServicio.findByEmailAndPassword(email, password);
		
		try {
			if(usuario != null) {
				return ResponseEntity.status(HttpStatus.OK).body(usuario);
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Error. No existe un usuario con ese email o password\"}");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the request, and try again later.\"}");
		}
	}
	
	@PostMapping("/")
	@CrossOrigin(origins = "*")
	public ResponseEntity save(@RequestBody Usuario usuario) throws Exception {
		
		Usuario usuarioTemp = usuarioServicio.save(usuario); //devuelve null si ya hay un usuario con ese email
		
		try {
			if(usuarioTemp != null) {
				return ResponseEntity.status(HttpStatus.OK).body(usuarioTemp);
			} else {
				return ResponseEntity.status(HttpStatus.CONFLICT).body("{\"message\": \"Error. Ya existe un usuario con ese correo electronico\"}");
			}
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the BODY request, and try again later.\"}");
						
		}
	}
	
	
	@PutMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity update(@RequestBody Usuario usuario, @PathVariable int id) {
		
		try {
			
			
			return ResponseEntity.status(HttpStatus.FOUND).body(usuarioServicio.update(id, usuario));
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID or BODY request, and try again later.\"}");
						
		}
		
	}
	
	
	@DeleteMapping("/{id}")
	@CrossOrigin(origins = "*")
	public ResponseEntity delete(@PathVariable int id) {
		
		try {
			usuarioServicio.delete(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body("");
			
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\": \"Error. Please check the ID, and try again later.\"}");
						
		}
		
	}

}

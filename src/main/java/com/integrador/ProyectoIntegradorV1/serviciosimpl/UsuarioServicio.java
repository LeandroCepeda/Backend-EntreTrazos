package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Usuario;
import com.integrador.ProyectoIntegradorV1.servicios.IUsuarioServicio;

@Service("UsuarioServicio")
public class UsuarioServicio implements IUsuarioServicio {

	@Override
	public List<Usuario> generarLista() {
		List<Usuario> usuarios = new ArrayList<>();
		
		for (int i = 0; i <= 25; i++) {
			Usuario usuario = new Usuario();
			usuario.setId(i);
			usuario.setNombre("Nombre #" + i);
			usuario.setApellido("Apellido #" + i);
			usuario.setPassword("1234");
			usuario.setEmail("Usuario" + i + "@gmail.com");
			usuario.setFechaNacimiento("10/06/96");
			usuarios.add(usuario);
		}	
		
		return usuarios;
	}

	@Override
	public Usuario buscarUsuarioPorId(int id, List<Usuario> usuario) {
		for (Usuario u : usuario) {
			if(u.getId() == id) {
				return u;
			}
		}
		return null;
	}

}

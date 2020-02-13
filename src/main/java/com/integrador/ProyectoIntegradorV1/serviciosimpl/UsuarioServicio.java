package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Usuario;
import com.integrador.ProyectoIntegradorV1.repositorios.UsuarioRepositorio;
import com.integrador.ProyectoIntegradorV1.servicios.IUsuarioServicio;

@Service("UsuarioServicio")
public class UsuarioServicio implements IUsuarioServicio {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Override
	public List<Usuario> findAll() throws Exception {
		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			
			for (Usuario usuario : usuarioRepositorio.findAll()) {
				usuarios.add(usuario);
			}	
			
			
		} catch (Exception e) {
			throw new Exception();
		}
		
		return usuarios;
	}

	
	@Override
	public Usuario findById(int id) throws Exception {
		Optional<Usuario> optional = usuarioRepositorio.findById(id);
		
		try {
			Usuario usuario = optional.get();
			return usuario;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}
	
	@Override
	public Usuario findByEmail(String email) throws Exception {
		return usuarioRepositorio.findByEmail(email);
	}

	
	@Override
	public Usuario save(Usuario usuario) throws Exception {
		if(usuarioRepositorio.findByEmail(usuario.getEmail()) != null) {
			return null;
		}
		try {
			usuarioRepositorio.save(usuario);
			return usuario;
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	@Override
	public Usuario update(int id, Usuario usuario) throws Exception {
		Optional<Usuario> optional = usuarioRepositorio.findById(id);
		Usuario usuarioActualizado = new Usuario();
		
		try {
			usuarioActualizado = optional.get();
			
			if(usuarioRepositorio.existsById(id)) {
				usuarioActualizado.setId(usuario.getId());
				usuarioActualizado.setNombre(usuario.getNombre());
				usuarioActualizado.setApellido(usuario.getApellido());
				usuarioActualizado.setPassword(usuario.getPassword());
				usuarioActualizado.setEmail(usuario.getEmail());
				usuarioActualizado.setFechaNacimiento(usuario.getFechaNacimiento());
				usuarioRepositorio.save(usuarioActualizado);
				return usuarioActualizado;
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public boolean delete(int id) throws Exception {
		try {
			if(usuarioRepositorio.existsById(id)) {
				usuarioRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			throw new Exception();
		}
	}


}

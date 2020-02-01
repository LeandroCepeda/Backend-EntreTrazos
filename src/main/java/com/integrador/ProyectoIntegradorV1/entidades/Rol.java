package com.integrador.ProyectoIntegradorV1.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="rol")
public class Rol {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
//	private List<Usuario> usuarios = new ArrayList<>();

	
	public Rol() {
	}


	public Rol(int id, String nombre, List<Usuario> usuarios) {
		this.id = id;
		this.nombre = nombre;
//		this.usuarios = usuarios;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


//	public List<Usuario> getUsuarios() {
//		return usuarios;
//	}
//
//
//	public void setUsuarios(List<Usuario> usuarios) {
//		this.usuarios = usuarios;
//	}
		
}

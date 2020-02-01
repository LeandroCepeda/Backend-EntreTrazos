package com.integrador.ProyectoIntegradorV1.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	private String apellido;
	
	private String password;
	
	private String email;
	
	private String fechaNacimiento;
	
//	private Rol rol;
//	
//	private Imagen imagen;
//	
//	private List<Compra> compras = new ArrayList<>();

	
	public Usuario() {
	}


	public Usuario(int id, String nombre, String apellido, String password, String email, String fechaNacimiento,
			Rol rol, Imagen imagen, List<Compra> compras) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
//		this.rol = rol;
//		this.imagen = imagen;
//		this.compras = compras;
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


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


//	public Rol getRol() {
//		return rol;
//	}
//
//
//	public void setRol(Rol rol) {
//		this.rol = rol;
//	}
//
//
//	public Imagen getImagen() {
//		return imagen;
//	}
//
//
//	public void setImagen(Imagen imagen) {
//		this.imagen = imagen;
//	}
//
//
//	public List<Compra> getCompras() {
//		return compras;
//	}
//
//
//	public void setCompras(List<Compra> compras) {
//		this.compras = compras;
//	}
	

}

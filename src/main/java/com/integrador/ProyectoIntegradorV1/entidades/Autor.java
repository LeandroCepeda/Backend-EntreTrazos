package com.integrador.ProyectoIntegradorV1.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "autor")
public class Autor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
	//private List<Libro> libros = new ArrayList<>();

	
	public Autor() {
		
	}

	
	public Autor(int id, String nombre, List<Libro> libros) {
		this.id = id;
		this.nombre = nombre;
//		this.libros = libros;
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



//	public List<Libro> getLibros() {
//		return libros;
//	}
//
//
//
//	public void setLibros(List<Libro> libros) {
//		this.libros = libros;
//	}
	
}

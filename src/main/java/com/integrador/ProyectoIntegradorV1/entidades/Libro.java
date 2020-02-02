package com.integrador.ProyectoIntegradorV1.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String isbn;
	
	private String titulo;
	
	private String editorial;
	
	private double precio;
	
	private String estado;
	
//	private Imagen imagen;
//	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_autor")
	private Autor autor;
//	
//	private Categoria categoria;

	
	public Libro() {
	}

	
	public Libro(int id, String isbn, String titulo, String editorial, double precio, String estado, Imagen imagen,
			Autor autor, Categoria categoria) {
		this.id = id;
		this.isbn = isbn;
		this.titulo = titulo;
		this.editorial = editorial;
		this.precio = precio;
		this.estado = estado;
//		this.imagen = imagen;
		this.autor = autor;
//		this.categoria = categoria;
	}

	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getIsbn() {
		return isbn;
	}

	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	
	public String getTitulo() {
		return titulo;
	}

	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	
	public String getEditorial() {
		return editorial;
	}

	
	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	
	public double getPrecio() {
		return precio;
	}

	
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	public String getEstado() {
		return estado;
	}

	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	
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
	public Autor getAutor() {
		return autor;
	}

	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
//
//	
//	public Categoria getCategoria() {
//		return categoria;
//	}
//
//	
//	public void setCategoria(Categoria categoria) {
//		this.categoria = categoria;
//	}

}

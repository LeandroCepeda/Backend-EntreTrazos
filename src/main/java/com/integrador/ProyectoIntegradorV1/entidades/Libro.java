package com.integrador.ProyectoIntegradorV1.entidades;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "libro")
public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank(message = "Debes especificar el ISBN")
	@Size(min = 13, max = 13, message= "El isbn de tener 13 dígitos")
	private String isbn;
	
	@NotEmpty(message = "Debes especificar el titulo")
	private String titulo;
	
	@NotEmpty(message = "Debes especificar la editorial")
	private String editorial;
	
	@NotNull(message = "Debes especificar el precio")
    @Min(value = 0, message = "El precio mínimo es 0")
	private double precio;
	
	@NotEmpty(message = "Debes especificar el estado")
	private String estado;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_imagen")
	private Imagen imagen;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_autor")
	private Autor autor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_categoria")
	private Categoria categoria;

	
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
		this.imagen = imagen;
		this.autor = autor;
		this.categoria = categoria;
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

	
	public Imagen getImagen() {
		return imagen;
	}

	
	public void setImagen(Imagen imagen) {
		this.imagen = imagen;
	}

	
	public Autor getAutor() {
		return autor;
	}

	
	public void setAutor(Autor autor) {
		this.autor = autor;
	}

	
	public Categoria getCategoria() {
		return categoria;
	}

	
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}

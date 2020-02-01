package com.integrador.ProyectoIntegradorV1.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="detalle_compra")
public class DetalleCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private double precioUnitario;
	
//	private Libro libro;
	
	
	public DetalleCompra() {
	}

	
	public DetalleCompra(int id, double precioUnitario, Libro libro) {
		this.id = id;
		this.precioUnitario = precioUnitario;
//		this.libro = libro;
	}
	
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}


	public double getPrecioUnitario() {
		return precioUnitario;
	}


	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	
//	public Libro getLibro() {
//		return libro;
//	}
//
//
//	public void setLibro(Libro libro) {
//		this.libro = libro;
//	}

}

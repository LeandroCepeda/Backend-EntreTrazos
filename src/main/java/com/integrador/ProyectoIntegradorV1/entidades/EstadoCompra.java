package com.integrador.ProyectoIntegradorV1.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estado_compra")
public class EstadoCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String nombre;
	
//	private List<Compra> compras = new ArrayList<>();

	
	public EstadoCompra() {
	}

	
	public EstadoCompra(int id, String nombre, List<Compra> compras) {
		this.id = id;
		this.nombre = nombre;
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

	
//	public List<Compra> getCompras() {
//		return compras;
//	}
//
//	
//	public void setCompras(List<Compra> compras) {
//		this.compras = compras;
//	}
	
}

package com.integrador.ProyectoIntegradorV1.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String fecha;
	
	private double total;
	
//	private Usuario usuario;
//	
//	private EstadoCompra estadoCompra;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name ="fk_compra")
	private List<DetalleCompra> detalles = new ArrayList<>();

	
	public Compra() {
	}


	public Compra(int id, String fecha, double total, Usuario usuario, EstadoCompra estadoCompra,
			List<DetalleCompra> detalles) {
		this.id = id;
		this.fecha = fecha;
		this.total = total;
//		this.usuario = usuario;
//		this.estadoCompra = estadoCompra;
		this.detalles = detalles;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}


//	public Usuario getUsuario() {
//		return usuario;
//	}
//
//
//	public void setUsuario(Usuario usuario) {
//		this.usuario = usuario;
//	}
//
//
//	public EstadoCompra getEstadoCompra() {
//		return estadoCompra;
//	}
//
//
//	public void setEstadoCompra(EstadoCompra estadoCompra) {
//		this.estadoCompra = estadoCompra;
//	}
//
//
	public List<DetalleCompra> getDetalles() {
		return detalles;
	}


	public void setDetalles(List<DetalleCompra> detalles) {
		this.detalles = detalles;
	}
	
}

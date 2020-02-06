package com.integrador.ProyectoIntegradorV1.servicios;

import java.util.List;

import com.integrador.ProyectoIntegradorV1.entidades.Compra;

public interface ICompraServicio {
	
	public List<Compra> findAll() throws Exception;
	
	public Compra findById(int id) throws Exception;
	
	public Compra save(Compra compra) throws Exception;
	
	public Compra update(int id, Compra compra) throws Exception;
	
	public boolean delete(int id) throws Exception;

}

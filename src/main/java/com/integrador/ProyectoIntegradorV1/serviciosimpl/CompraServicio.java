package com.integrador.ProyectoIntegradorV1.serviciosimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.integrador.ProyectoIntegradorV1.entidades.Compra;
import com.integrador.ProyectoIntegradorV1.entidades.DetalleCompra;
import com.integrador.ProyectoIntegradorV1.entidades.Libro;
import com.integrador.ProyectoIntegradorV1.repositorios.CompraRepositorio;
import com.integrador.ProyectoIntegradorV1.servicios.ICompraServicio;
import com.integrador.ProyectoIntegradorV1.servicios.ILibroServicio;

@Service("CompraServicio")
public class CompraServicio implements ICompraServicio {
	
	@Autowired
	private CompraRepositorio compraRepositorio;
	
	@Autowired
	@Qualifier("LibroServicio")
	private ILibroServicio libroServicio;

	
	@Override
	public List<Compra> findAll() throws Exception {
		List<Compra> compras = new ArrayList<>();
		
		try {
			
			for (Compra compra : compraRepositorio.findAll()) {
				compras.add(compra);
			}	
			
			
		} catch (Exception e) {
			throw new Exception();
		}
		
		return compras;
	}

	
	@Override
	public Compra findById(int id) throws Exception {
		Optional<Compra> optional = compraRepositorio.findById(id);
		
		try {
			Compra compra = optional.get();
			return compra;
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	

	@Override
	public Compra save(Compra compra) throws Exception {
		
		try {
			for (DetalleCompra detalle : compra.getDetalles()) {
				Libro libro = libroServicio.findByTitulo(detalle.getLibro().getTitulo());
				detalle.setPrecioUnitario(detalle.getPrecioUnitario());
				detalle.setLibro(libro); //PARA QUE NO ME CREE OTRO LIBRO, SINO ARMAR LA RELACION CON UN LIBRO EXISTENTE.
			}
			return compraRepositorio.save(compra);
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	@Override
	public Compra update(int id, Compra compra) throws Exception {
		Optional<Compra> optional = compraRepositorio.findById(id);
		Compra compraNueva = new Compra();

		try {
			Compra compraBD = optional.get();
			
			if(!compraBD.getDetalles().equals(compra.getDetalles())) {
				compraNueva.setDetalles(compra.getDetalles());
			} else {
				compraNueva.setDetalles(compraBD.getDetalles());
			}
			
			compraNueva.setId(compra.getId());
			compraNueva.setFecha(compra.getFecha());
			compraNueva.setTotal(compra.getTotal());		
			return compraRepositorio.save(compraNueva);
			
		} catch (Exception e) {
			throw new Exception();
		}
		
	}

	@Override
	public boolean delete(int id) throws Exception {
		try {
			if(compraRepositorio.existsById(id)) {
				compraRepositorio.deleteById(id);
				return true;
			} else {
				throw new Exception();
			}
			
		} catch (Exception e) {
			throw new Exception();
		}
	}
	
	
}

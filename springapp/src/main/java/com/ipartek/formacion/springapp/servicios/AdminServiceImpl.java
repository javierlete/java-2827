package com.ipartek.formacion.springapp.servicios;

import java.util.logging.Level;

import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import com.ipartek.formacion.springapp.entidades.Categoria;
import com.ipartek.formacion.springapp.entidades.Producto;
import com.ipartek.formacion.springapp.repositorios.CategoriaRepository;
import com.ipartek.formacion.springapp.repositorios.ProductoRepository;

import jakarta.validation.Valid;
import lombok.extern.java.Log;

@Validated
@Service
@Log
public class AdminServiceImpl extends AnonimoServiceImpl implements AdminService {
	public AdminServiceImpl(ProductoRepository productoRepo, CategoriaRepository categoriaRepo) {
		super(productoRepo, categoriaRepo);
	}

	@Override
	public void anyadirProducto(@Valid Producto producto) {
		log.log(Level.INFO, "Se va a añadir un producto {0}", producto);
		
		if(producto.getCategoria() == null) {
			producto.setCategoria(Categoria.builder().id(1L).build());
		}
		
		productoRepo.save(producto);
	}

	@Override
	public void modificarProducto(@Valid Producto producto) {
		log.log(Level.INFO, "Se va a modificar el producto {0}", producto);
		
		if(producto.getCategoria() == null) {
			producto.setCategoria(Categoria.builder().id(1L).build());
		}
		
		productoRepo.save(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		productoRepo.deleteById(id);
	}

	@Override
	public Iterable<Categoria> listarCategorias() {
		return categoriaRepo.findAll();
	}
}

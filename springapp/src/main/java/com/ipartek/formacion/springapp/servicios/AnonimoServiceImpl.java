package com.ipartek.formacion.springapp.servicios;

import java.util.Collection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ipartek.formacion.springapp.entidades.Categoria;
import com.ipartek.formacion.springapp.entidades.Producto;
import com.ipartek.formacion.springapp.repositorios.CategoriaRepository;
import com.ipartek.formacion.springapp.repositorios.ProductoRepository;

import lombok.AllArgsConstructor;

@Primary
@Service
@AllArgsConstructor
public class AnonimoServiceImpl implements AnonimoService {
	protected ProductoRepository productoRepo;
	private CategoriaRepository categoriaRepo;
	
	@Override
	public Iterable<Producto> listarProductos() {
		return productoRepo.findAll();
	}

	@Override
	public Producto buscarProductoPorId(Long id) {
		return productoRepo.findById(id).orElse(null);
	}

	@Override
	public Iterable<Categoria> listarCategorias() {
		var categorias = categoriaRepo.findAll();
		
		if(categorias instanceof Collection<Categoria> coleccion) {
			return coleccion.stream().filter(categoria -> categoria.getId() != 1L).toList();
		}
		
		throw new ServicioException("Las categorías no se pueden filtrar por un stream");
	}

	@Override
	public Categoria detalleCategoria(Long id) {
		return categoriaRepo.findById(id).orElse(null);
	}

	@Override
	public Iterable<Producto> productosDeCategoria(Long idCategoria) {
		return productoRepo.findByCategoriaId(idCategoria);
	}

}

package com.ipartek.formacion.springapp.repositorios;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.springapp.entidades.Producto;

@RepositoryRestResource(collectionResourceRel = "productos", path = "productos")
public interface ProductoRepository extends CrudRepository<Producto, Long>, PagingAndSortingRepository<Producto, Long> {
	@EntityGraph(attributePaths = {"categoria"})
	Iterable<Producto> findAll();
	
	@EntityGraph(attributePaths = {"categoria"})
	Iterable<Producto> findByNombre(String nombre);
	
	@EntityGraph(attributePaths = {"categoria"})
	Iterable<Producto> findByPrecioBetween(BigDecimal minimo, BigDecimal maximo);
	
	@EntityGraph(attributePaths = {"categoria"})
	Iterable<Producto> findByCategoriaId(Long idCategoria);
}

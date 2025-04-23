package com.ipartek.formacion.multimodulo.accesodatos.map;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.ipartek.formacion.bibliotecas.AccesoDatosException;
import com.ipartek.formacion.multimodulo.accesodatos.ProductoDao;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public class ProductoDaoMap implements ProductoDao {
	private static final SortedMap<Long, Producto> productos = new TreeMap<>(
			Map.of(
					1L, Producto.builder().id(1L).nombre("Producto1").precio(new BigDecimal("1234")).build(), 
					2L,	Producto.builder().id(2L).nombre("Producto2").precio(new BigDecimal("2234")).build(), 
					3L,	Producto.builder().id(3L).nombre("Producto3").precio(new BigDecimal("3234")).build(), 
					4L, Producto.builder().id(4L).nombre("Producto4").precio(new BigDecimal("4234")).build()
			));

	public ProductoDaoMap(String ignorado1, String ignorado2, String ignorado3) {

	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		Long id = productos.size() > 0 ? productos.lastKey() + 1L: 1L;
		producto.setId(id);
		productos.put(id, producto);

		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		if(!productos.containsKey(producto.getId())) {
			throw new AccesoDatosException("No existe un producto con esa clave para modificarlo");
		}
		
		productos.put(producto.getId(), producto);

		return producto;
	}

	@Override
	public void borrar(Long id) {
		productos.remove(id);
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		return productos.values().stream().filter(p -> p.getNombre().contains(nombre)).toList();
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
		return productos.values().stream()
				.filter(p -> p.getPrecio().compareTo(minimo) >= 0 && p.getPrecio().compareTo(maximo) <= 0).toList();
	}

}

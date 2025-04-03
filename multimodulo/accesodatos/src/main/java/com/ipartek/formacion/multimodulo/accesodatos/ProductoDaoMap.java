package com.ipartek.formacion.multimodulo.accesodatos;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import com.ipartek.formacion.bibliotecas.AccesoDatosException;
import com.ipartek.formacion.multimodulo.entidades.Producto;

public class ProductoDaoMap implements ProductoDao {
	private static final SortedMap<Long, Producto> productos = new TreeMap<>(
			Map.of(1L, new Producto(1L, "Producto1", new BigDecimal("1234"), null), 2L,
					new Producto(2L, "Producto2", new BigDecimal("2234"), null), 3L,
					new Producto(3L, "Producto3", new BigDecimal("3234"), null), 4L,
					new Producto(4L, "Producto4", new BigDecimal("4234"), null)));

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

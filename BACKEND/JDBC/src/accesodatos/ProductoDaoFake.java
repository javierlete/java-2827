package accesodatos;

import java.math.BigDecimal;
import java.util.ArrayList;

import entidades.Producto;

class ProductoDaoFake implements ProductoDao {
	@Override
	public Iterable<Producto> obtenerTodos() {
		System.out.println("OBTENER TODOS LOS PRODUCTOS");
		
		return new ArrayList<>();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		System.out.println("OBTENER PRODUCTO ID " + id);
		
		return new Producto();
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		System.out.println("BUSCAR POR NOMBRE " + nombre);
		
		return new ArrayList<>();
	}

	@Override
	public Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo) {
System.out.println("BUSCAR POR PRECIO ENTRE " + minimo + " Y " + maximo);
		
		return new ArrayList<>();
	}

	@Override
	public Producto insertar(Producto producto) {
		System.out.println("INSERTANDO " + producto);
		
		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		System.out.println("MODIFICANDO " + producto);
		
		return producto;
	}

	@Override
	public void borrar(Long id) {
		System.out.println("BORRANDO " + id);
	}
}
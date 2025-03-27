package accesodatos;

import java.math.BigDecimal;

import bibliotecas.Dao;
import entidades.Producto;

public interface ProductoDao extends Dao<Producto> {
	Iterable<Producto> buscarPorNombre(String nombre);
	Iterable<Producto> buscarPorPrecio(BigDecimal minimo, BigDecimal maximo);
}

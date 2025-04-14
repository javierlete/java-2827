package com.ipartek.formacion.multimodulo.presentacion.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.ipartek.formacion.multimodulo.entidades.Producto;

public class Carrito implements Serializable {
	private static final long serialVersionUID = 4134088018547327728L;

	private Map<Long, LineaCarrito> lineas = new LinkedHashMap<>();

	public Iterable<LineaCarrito> getLineas() {
		return Collections.unmodifiableCollection(lineas.values());
	}

	public LineaCarrito getLineaPorId(Long id) {
		return lineas.get(id);
	}

	public void ponerLinea(LineaCarrito linea) {
		lineas.put(linea.getProducto().getId(), linea);
	}

	public void quitarLinea(Long id) {
		lineas.remove(id);
	}

	public BigDecimal getTotal() {
		return lineas.values().stream().map(l -> l.getTotal()).reduce(BigDecimal.ZERO,
				(totalParcial, acumulado) -> acumulado.add(totalParcial));
	}

	public static class LineaCarrito implements Serializable {
		private static final long serialVersionUID = 507537865208658991L;

		private Producto producto;
		private Integer cantidad;

		public LineaCarrito(Producto producto, Integer cantidad) {
			super();
			this.producto = producto;
			this.cantidad = cantidad;
		}

		public Producto getProducto() {
			return producto;
		}

		public void setProducto(Producto producto) {
			this.producto = producto;
		}

		public Integer getCantidad() {
			return cantidad;
		}

		public void setCantidad(Integer cantidad) {
			this.cantidad = cantidad;
		}

		public BigDecimal getTotal() {
			return producto.getPrecio().multiply(new BigDecimal(cantidad));
		}

		@Override
		public int hashCode() {
			return Objects.hash(cantidad, producto);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			LineaCarrito other = (LineaCarrito) obj;
			return Objects.equals(cantidad, other.cantidad) && Objects.equals(producto, other.producto);
		}

		@Override
		public String toString() {
			return String.format("LineaCarrito [producto=%s, cantidad=%s]", producto, cantidad);
		}

	}
}

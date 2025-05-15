package com.ipartek.formacion.springapp.modelos;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.ipartek.formacion.springapp.entidades.Producto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@SessionScope
public class Carrito {
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

	@Builder
	@NoArgsConstructor
	@AllArgsConstructor
	@Data
	public static class LineaCarrito {
		private Producto producto;
		private Integer cantidad;

		public BigDecimal getTotal() {
			return producto.getPrecio().multiply(new BigDecimal(cantidad));
		}
	}
}

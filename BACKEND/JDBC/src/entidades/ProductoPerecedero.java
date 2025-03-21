package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class ProductoPerecedero extends Producto {
	private LocalDate caducidad;

	public ProductoPerecedero(Long id, String nombre, BigDecimal precio, LocalDate caducidad, String descripcion,
			Categoria categoria) {
		super(id, nombre, precio, descripcion, categoria);
		this.caducidad = caducidad;
	}

	public ProductoPerecedero() {
		this(null, NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, null, null, null);
	}

	public ProductoPerecedero(Long id, String nombre, BigDecimal precio, String descripcion, Categoria categoria) {
		this(id, nombre, precio, null, descripcion, categoria);
	}

	public ProductoPerecedero(Long id, String nombre, BigDecimal precio, String descripcion) {
		this(id, nombre, precio, null, descripcion, null);
	}

	public ProductoPerecedero(String nombre, BigDecimal precio, String descripcion) {
		this(null, nombre, precio, null, descripcion, null);
	}

	public ProductoPerecedero(String nombre, BigDecimal precio) {
		this(null, nombre, precio, null, null, null);
	}

	public ProductoPerecedero(long id, String nombre, BigDecimal precio, LocalDate caducidad, String descripcion) {
		this(id, nombre, precio, caducidad, descripcion, null);
	}

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		if (caducidad != null && caducidad.isBefore(LocalDate.now())) {
			throw new EntidadesException("No se pueden crear productos caducados");
		}

		this.caducidad = caducidad;
	}

	// MÉTODOS DE INSTANCIA
	public boolean isCaducado() {
		if (caducidad == null) {
			throw new EntidadesException("No hay caducidad");
		}

		return caducidad.isBefore(LocalDate.now());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(caducidad);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoPerecedero other = (ProductoPerecedero) obj;
		return Objects.equals(caducidad, other.caducidad);
	}

	@Override
	public String toString() {
		return String.format(
				"ProductoPerecedero [id=%s, nombre=%s, precio=%s, caducidad=%s, descripcion=%s, categoria=%s]",
				getId(), getNombre(), getPrecio(), getCaducidad(), getDescripcion(), getCategoria());
	}
	
	
}

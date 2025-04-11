package com.ipartek.formacion.multimodulo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Producto implements Serializable, Formateable {
	private static final long serialVersionUID = 1564087494724474758L;
	
	// CONSTANTES
	protected static final String NOMBRE_POR_DEFECTO = "NO TIENE NOMBRE";
	protected static final BigDecimal PRECIO_POR_DEFECTO = BigDecimal.ZERO;
	
	// VARIABLES ESTÁTICAS / "DE CLASE" / "COMPARTIDAS"
	private static int maximoNombre;

	// BLOQUE ESTÁTICO / "CONSTRUCTOR ESTÁTICO" / "CONSTRUCTOR DE CLASE"
	static {
		maximoNombre = 45;
	}

	// VARIABLES DE INSTANCIA / ATRIBUTOS / CAMPOS / FIELDS
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private String descripcion;

	private Categoria categoria;

	// CONSTRUCTORES
	public Producto(Long id, String nombre, BigDecimal precio, String descripcion,
			Categoria categoria) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setDescripcion(descripcion);
		setCategoria(categoria);
	}

	public Producto(Long id, String nombre, BigDecimal precio, String descripcion) {
		this(id, nombre, precio, descripcion, null);
	}

	public Producto(String nombre, BigDecimal precio, String descripcion) {
		this(null, nombre, precio, descripcion, null);
	}

	public Producto(String nombre, BigDecimal precio) {
		this(null, nombre, precio, null, null);
	}

	public Producto() {
		this(null, NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, null, null);
	}

	// GETTERS Y SETTERS / PROPIEDADES
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if (id != null && id < 0) {
			throw new EntidadesException("No se admiten valores negativos");
		}

		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.length() > maximoNombre) {
			throw new EntidadesException("No se admiten valores superiores a " + maximoNombre + " caracteres ni nulos");
		}

		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		if (precio == null) {
			throw new EntidadesException("No se admiten precios nulos");
		}

		this.precio = precio;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public static int getMaximoNombre() {
		return maximoNombre;
	}

	public static void setMaximoNombre(int maximoNombre) {
		Producto.maximoNombre = maximoNombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(categoria, descripcion, id, nombre, precio);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		return Objects.equals(categoria, other.categoria) && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", descripcion=" + descripcion
				+ ", categoria=" + categoria + "]";
	}

	@Override
	public String formatear() {
		return String.format("""
				%11s: %s
				%11s: %s
				%11s: %s
				""", "Id", id, "Nombre", nombre, "Precio", precio);
	}

}
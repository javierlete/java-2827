package entidades;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Producto {
	// CONSTANTES
	private static final String NOMBRE_POR_DEFECTO = "NO TIENE NOMBRE";
	private static final BigDecimal PRECIO_POR_DEFECTO = BigDecimal.ZERO;
	
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
	private LocalDate caducidad;
	private String descripcion;

	private Categoria categoria;

	// CONSTRUCTORES
	public Producto(Long id, String nombre, BigDecimal precio, LocalDate caducidad, String descripcion,
			Categoria categoria) {
		setId(id);
		setNombre(nombre);
		setPrecio(precio);
		setCaducidad(caducidad);
		setDescripcion(descripcion);
		setCategoria(categoria);
	}

	public Producto(Long id, String nombre, BigDecimal precio, LocalDate caducidad, String descripcion) {
		this(id, nombre, precio, caducidad, descripcion, null);
	}

	public Producto(String nombre, BigDecimal precio, LocalDate caducidad, String descripcion) {
		this(null, nombre, precio, caducidad, descripcion, null);
	}

	public Producto(String nombre, BigDecimal precio, LocalDate caducidad) {
		this(null, nombre, precio, caducidad, null, null);
	}

	public Producto(String nombre, BigDecimal precio) {
		this(null, nombre, precio, null, null, null);
	}

	public Producto() {
		this(null, NOMBRE_POR_DEFECTO, PRECIO_POR_DEFECTO, null, null, null);
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

	public LocalDate getCaducidad() {
		return caducidad;
	}

	public void setCaducidad(LocalDate caducidad) {
		if (caducidad != null && caducidad.isBefore(LocalDate.now())) {
			throw new EntidadesException("No se pueden crear productos caducados");
		}

		this.caducidad = caducidad;
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

	// MÉTODOS DE INSTANCIA
	public boolean isCaducado() {
		if (caducidad == null) {
			throw new EntidadesException("No hay caducidad");
		}

		return caducidad.isBefore(LocalDate.now());
	}

	@Override
	public int hashCode() {
		return Objects.hash(caducidad, categoria, descripcion, id, nombre, precio);
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
		return Objects.equals(caducidad, other.caducidad) && Objects.equals(categoria, other.categoria)
				&& Objects.equals(descripcion, other.descripcion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(precio, other.precio);
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", caducidad=" + caducidad
				+ ", descripcion=" + descripcion + ", categoria=" + categoria + "]";
	}

}
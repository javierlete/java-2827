package com.ipartek.formacion.multimodulo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.ipartek.formacion.bibliotecas.Identificable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto implements Identificable, Serializable, Formateable {
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
	
	@Builder.Default
	private String nombre = NOMBRE_POR_DEFECTO;
	
	@Builder.Default
	private BigDecimal precio = PRECIO_POR_DEFECTO;
	
	private String descripcion;
	
	@Builder.Default
	private Map<String, String> errores = new HashMap<>();

	private Categoria categoria;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		if (id != null && id < 0) {
			errores.put("id", "No se admiten valores negativos");
		}

		this.id = id;
	}

	public void setNombre(String nombre) {
		if (nombre == null || nombre.isBlank() || nombre.length() > maximoNombre) {
			errores.put("nombre", "El nombre debe rellenarse y debe tener como máximo " + maximoNombre + " caracteres");
		}

		this.nombre = nombre;
	}

	public void setPrecio(BigDecimal precio) {
		if (precio == null || precio.compareTo(BigDecimal.ZERO) < 0) {
			errores.put("precio", "El precio es obligatorio y debe ser mayor o igual que 0");
		}

		this.precio = precio;
	}

	public void setDescripcion(String descripcion) {
		if(descripcion != null && descripcion.length() > 2000) {
			errores.put("descripcion", "La descripción no puede tener más de 2000 caracteres");
		}
		
		this.descripcion = descripcion;
	}

	public static int getMaximoNombre() {
		return maximoNombre;
	}

	public static void setMaximoNombre(int maximoNombre) {
		Producto.maximoNombre = maximoNombre;
	}
	
	public boolean hayErrores() {
		return errores.size() > 0;
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
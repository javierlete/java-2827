package com.ipartek.formacion.multimodulo.entidades;

import java.io.Serializable;
import java.math.BigDecimal;

import com.ipartek.formacion.bibliotecas.Identificable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "productos")
public class Producto implements Identificable, Serializable, Formateable {
	private static final long serialVersionUID = 1564087494724474758L;
	
	// CONSTANTES
	protected static final String NOMBRE_POR_DEFECTO = "NO TIENE NOMBRE";
	protected static final BigDecimal PRECIO_POR_DEFECTO = BigDecimal.ZERO;
	
	// VARIABLES DE INSTANCIA / ATRIBUTOS / CAMPOS / FIELDS
	@PositiveOrZero
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 45)
	@Builder.Default
	private String nombre = NOMBRE_POR_DEFECTO;
	
	@NotNull
	@PositiveOrZero
	@Builder.Default
	private BigDecimal precio = PRECIO_POR_DEFECTO;
	
	@Size(max = 2000)
	@Lob
	private String descripcion;
	
	@ManyToOne
	private Categoria categoria;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
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
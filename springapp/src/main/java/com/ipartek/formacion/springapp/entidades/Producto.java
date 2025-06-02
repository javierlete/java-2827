package com.ipartek.formacion.springapp.entidades;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name = "productos")
public class Producto {
	// VARIABLES DE INSTANCIA / ATRIBUTOS / CAMPOS / FIELDS
	@PositiveOrZero
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 45)
	private String nombre;
	
	@NotNull
	@PositiveOrZero
	private BigDecimal precio;
	
	@Size(max = 2000)
	@Lob
	private String descripcion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Categoria categoria;
	
	@JsonIgnore
	public String getPrecioFormateado() {
		NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.of("es", "ES"));
	    return currencyFormatter.format(precio);
	}
}
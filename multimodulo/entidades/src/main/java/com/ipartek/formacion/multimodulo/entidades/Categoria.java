package com.ipartek.formacion.multimodulo.entidades;

import java.io.Serializable;
import java.util.ArrayList;

import com.ipartek.formacion.bibliotecas.Identificable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Categoria implements Identificable, Serializable, Formateable  {
	private static final long serialVersionUID = -7383446729198770780L;
	
	@PositiveOrZero
	private Long id;
	
	@NotBlank
	@Size(max = 50)
	private String nombre;
	
	@Size(max = 2000)
	private String descripcion;
	
	@Builder.Default
	private ArrayList<Producto> productos = new ArrayList<>();

	@Override
	public void setId(Long id) {
		this.id = id;
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public String formatear() {
		return String.format("""
				%11s: %s
				%11s: %s
				%11s: %s
				""", "Id", id, "Nombre", nombre, "Descripcion", descripcion);
	}

}

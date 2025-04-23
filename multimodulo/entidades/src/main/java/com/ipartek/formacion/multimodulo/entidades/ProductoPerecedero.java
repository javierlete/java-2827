package com.ipartek.formacion.multimodulo.entidades;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class ProductoPerecedero extends Producto implements Formateable {
	private static final long serialVersionUID = -6065027374776025199L;
	
	private LocalDate caducidad;

	@Override
	public String getNombre() {
		if(isCaducado()) {
			return super.getNombre() + " CADUCADO";
		}
		
		return super.getNombre();
	}

	public void setCaducidad(LocalDate caducidad) {
		if (caducidad == null || caducidad.isBefore(LocalDate.now())) {
			throw new EntidadesException("No se pueden crear productos caducados o sin caducidad");
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
	public String formatear() {
		return super.formatear() + String.format("""
				%11s: %s
				""", "Caducidad", caducidad);
	}
	
	
}

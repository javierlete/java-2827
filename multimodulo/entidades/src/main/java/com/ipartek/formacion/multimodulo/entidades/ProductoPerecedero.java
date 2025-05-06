package com.ipartek.formacion.multimodulo.entidades;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
public class ProductoPerecedero extends Producto implements Formateable {
	private static final long serialVersionUID = -6065027374776025199L;
	
	@NotNull
	@FutureOrPresent
	private LocalDate caducidad;

	@Override
	public String getNombre() {
		if(isCaducado()) {
			return super.getNombre() + " CADUCADO";
		}
		
		return super.getNombre();
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

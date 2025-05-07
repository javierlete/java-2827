package com.ipartek.formacion.springapp.entidades;

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
public class ProductoPerecedero extends Producto {
	@NotNull
	@FutureOrPresent
	private LocalDate fechaCaducidad;

	@Override
	public String getNombre() {
		if(isCaducado()) {
			return super.getNombre() + " CADUCADO";
		}
		
		return super.getNombre();
	}

	// MÉTODOS DE INSTANCIA
	public boolean isCaducado() {
		if (fechaCaducidad == null) {
			throw new EntidadesException("No hay caducidad");
		}

		return fechaCaducidad.isBefore(LocalDate.now());
	}
}

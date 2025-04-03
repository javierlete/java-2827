package com.ipartek.formacion.multimodulo.entidades;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EmpleadoIndefinido extends Empleado {
	private BigDecimal sueldoAnual;
	private Integer numeroPagas;

	public EmpleadoIndefinido(Long id, String nombre, String nif, String nss, BigDecimal sueldoAnual,
			Integer numeroPagas) {
		super(id, nombre, nif, nss);
		this.sueldoAnual = sueldoAnual;
		this.numeroPagas = numeroPagas;
	}

	public BigDecimal getSueldoAnual() {
		return sueldoAnual;
	}

	public void setSueldoAnual(BigDecimal sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
	}

	public Integer getNumeroPagas() {
		return numeroPagas;
	}

	public void setNumeroPagas(Integer numeroPagas) {
		this.numeroPagas = numeroPagas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroPagas, sueldoAnual);
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
		EmpleadoIndefinido other = (EmpleadoIndefinido) obj;
		return Objects.equals(numeroPagas, other.numeroPagas) && Objects.equals(sueldoAnual, other.sueldoAnual);
	}

	@Override
	public String toString() {
		return String.format("EmpleadoIndefinido [sueldoAnual=%s, numeroPagas=%s]", sueldoAnual, numeroPagas);
	}

	@Override
	public BigDecimal getSueldo() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), 2, RoundingMode.HALF_UP);
	}

}

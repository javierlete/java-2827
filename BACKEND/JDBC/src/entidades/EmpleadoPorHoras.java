package entidades;

import java.math.BigDecimal;
import java.util.Objects;

public class EmpleadoPorHoras extends Empleado {
	private Integer numeroHoras;
	private BigDecimal sueldoHora;

	public EmpleadoPorHoras(Long id, String nombre, String nif, String nss, Integer numeroHoras,
			BigDecimal sueldoHora) {
		super(id, nombre, nif, nss);
		this.numeroHoras = numeroHoras;
		this.sueldoHora = sueldoHora;
	}

	public Integer getNumeroHoras() {
		return numeroHoras;
	}

	public void setNumeroHoras(Integer numeroHoras) {
		this.numeroHoras = numeroHoras;
	}

	public BigDecimal getSueldoHora() {
		return sueldoHora;
	}

	public void setSueldoHora(BigDecimal sueldoHora) {
		this.sueldoHora = sueldoHora;
	}

	@Override
	public BigDecimal getSueldo() {
		return sueldoHora.multiply(new BigDecimal(numeroHoras));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroHoras, sueldoHora);
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
		EmpleadoPorHoras other = (EmpleadoPorHoras) obj;
		return Objects.equals(numeroHoras, other.numeroHoras) && Objects.equals(sueldoHora, other.sueldoHora);
	}

	@Override
	public String toString() {
		return String.format("EmpleadoPorHoras [numeroHoras=%s, sueldoHora=%s]", numeroHoras, sueldoHora);
	}

}

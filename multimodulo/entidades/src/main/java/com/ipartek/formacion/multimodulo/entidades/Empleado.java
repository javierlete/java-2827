package com.ipartek.formacion.multimodulo.entidades;

import java.math.BigDecimal;
import java.util.Objects;

public abstract class Empleado {
	private Long id;
	private String nombre;
	private String nif;
	private String nss;

	protected Empleado(Long id, String nombre, String nif, String nss) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nif = nif;
		this.nss = nss;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNss() {
		return nss;
	}

	public void setNss(String nss) {
		this.nss = nss;
	}
	
	public abstract BigDecimal getSueldo();
	
	public BigDecimal getIrpf() {
		return getSueldo().multiply(new BigDecimal("0.35"));
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, nif, nombre, nss);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(id, other.id) && Objects.equals(nif, other.nif) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(nss, other.nss);
	}

	@Override
	public String toString() {
		return String.format("Empleado [id=%s, nombre=%s, nif=%s, nss=%s]", id, nombre, nif, nss);
	}
}

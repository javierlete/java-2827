package com.ipartek.formacion.multimodulo.entidades;

import java.io.Serializable;
import java.util.Set;

import com.ipartek.formacion.bibliotecas.Identificable;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "categorias")
public class Categoria implements Identificable, Serializable, Formateable  {
	private static final long serialVersionUID = -7383446729198770780L;
	
	@PositiveOrZero
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 50)
	private String nombre;
	
	@Size(max = 2000)
	@Lob
	private String descripcion;
	
	@JsonbTransient
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "categoria")
	private Set<Producto> productos;

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

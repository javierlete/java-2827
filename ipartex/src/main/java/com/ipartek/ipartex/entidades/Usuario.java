package com.ipartek.ipartex.entidades;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

@Entity
@Table(name = "usuarios")
@JsonIgnoreProperties(value = {"password"}, allowSetters = true)
public class Usuario implements Serializable {
	private static final long serialVersionUID = 5516703573026975230L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 25)
	@Column(unique = true)
	private String nombre;
	
	@NotBlank
	@Email
	@Size(max = 100)
	@Column(unique = true)
	private String email;
	
	@NotBlank
	@Size(max = 100)
	private String password;
}

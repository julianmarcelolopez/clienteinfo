package com.jlopez.clienteinfo.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@ToString
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "nombre", nullable = true)
	@NonNull
	private String nombre;

	@Column(name = "apellido", nullable = true)
	@NonNull
	private String apellido;

	@Column(name = "edad", nullable = true)
	private int edad;

	@Column(name = "fecha_nacimiento", nullable = true)
	@NonNull
	private LocalDate fechaNacimiento;

}
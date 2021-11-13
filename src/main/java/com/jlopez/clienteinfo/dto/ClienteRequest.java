package com.jlopez.clienteinfo.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ClienteRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellido;
	private int edad;
	private LocalDate fechaNacimiento;
}

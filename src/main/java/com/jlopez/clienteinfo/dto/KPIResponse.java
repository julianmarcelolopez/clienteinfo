package com.jlopez.clienteinfo.dto;

import java.io.Serializable;

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
public class KPIResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Double promedioEdad;
	private Double desviacionEstandarEdad;
}

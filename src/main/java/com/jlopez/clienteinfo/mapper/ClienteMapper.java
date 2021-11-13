package com.jlopez.clienteinfo.mapper;

import com.jlopez.clienteinfo.dto.ClienteRequest;
import com.jlopez.clienteinfo.dto.ClienteResponse;
import com.jlopez.clienteinfo.model.Cliente;

public class ClienteMapper {

	private static final int PROMEDIO_EXPECTATIVA_DE_VIDA = 72;

	private ClienteMapper() {
	}

	public static Cliente clienteRequestToEntity(ClienteRequest clienteRequest) {
		return Cliente.builder().nombre(clienteRequest.getNombre()).apellido(clienteRequest.getApellido())
				.edad(clienteRequest.getEdad()).fechaNacimiento(clienteRequest.getFechaNacimiento()).build();
	}

	public static ClienteResponse clienteToClienteResponse(Cliente cliente) {

		return ClienteResponse.builder().id(cliente.getId()).nombre(cliente.getNombre()).apellido(cliente.getApellido())
				.edad(cliente.getEdad()).fechaNacimiento(cliente.getFechaNacimiento().toString())
				.fechaEstimadaFallecimiento(
						cliente.getFechaNacimiento().plusYears(PROMEDIO_EXPECTATIVA_DE_VIDA).toString())
				.build();

	}

}
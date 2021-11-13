package com.jlopez.clienteinfo.service;

import java.util.List;

import com.jlopez.clienteinfo.dto.ClienteRequest;
import com.jlopez.clienteinfo.dto.ClienteResponse;
import com.jlopez.clienteinfo.dto.KPIResponse;

public interface ClienteService {

	public List<ClienteResponse> getAll() throws Exception;

	public KPIResponse getKPI() throws Exception;

	public void saveCliente(ClienteRequest clienteRequest) throws Exception;

}

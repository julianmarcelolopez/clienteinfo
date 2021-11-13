package com.jlopez.clienteinfo.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.math.Stats;
import com.jlopez.clienteinfo.dto.ClienteRequest;
import com.jlopez.clienteinfo.dto.ClienteResponse;
import com.jlopez.clienteinfo.dto.KPIResponse;
import com.jlopez.clienteinfo.exception.custom.FieldExistCustomException;
import com.jlopez.clienteinfo.exception.custom.NotFoundCustomException;
import com.jlopez.clienteinfo.mapper.ClienteMapper;
import com.jlopez.clienteinfo.model.Cliente;
import com.jlopez.clienteinfo.repository.ClienteRepository;
import com.jlopez.clienteinfo.service.ClienteService;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository repository;

	@Autowired
	public void setRepository(ClienteRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<ClienteResponse> getAll() throws Exception {
		log.info("Get All Clientes...");
		return this.findAll().stream().map(ClienteMapper::clienteToClienteResponse).collect(Collectors.toList());
	}

	@Override
	public KPIResponse getKPI() throws Exception {
		log.info("Get KPI...");
		List<Cliente> clienteList = this.findAll();
		List<Integer> ageList = clienteList.stream().map(Cliente::getEdad)
				.collect(Collectors.toList());

		return KPIResponse.builder().promedioEdad(Stats.of(ageList).mean())
				.desviacionEstandarEdad(Stats.of(ageList).populationStandardDeviation()).build();
	}

	@Override
	public void saveCliente(ClienteRequest clienteRequest) throws Exception {
		log.info("Saving Cliente...");
		Cliente clienteExistente = repository.findByNombreAndApellido(clienteRequest.getNombre(),
				clienteRequest.getApellido());
		if (clienteExistente != null)
			throw new FieldExistCustomException(
					clienteExistente.getNombre().concat(" ").concat(clienteExistente.getApellido()));

		Cliente cliente = ClienteMapper.clienteRequestToEntity(clienteRequest);
		repository.save(cliente);

	}

	private List<Cliente> findAll() throws Exception {
		log.info("Searching Cliente...");
		List<Cliente> clienteList = repository.findAll();
		if (clienteList.isEmpty())
			throw new NotFoundCustomException("No tiene clientes");
		return clienteList;
	}

}

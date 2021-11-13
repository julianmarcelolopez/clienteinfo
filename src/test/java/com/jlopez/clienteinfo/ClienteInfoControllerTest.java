package com.jlopez.clienteinfo;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.jlopez.clienteinfo.controller.ClienteController;
import com.jlopez.clienteinfo.dto.ClienteResponse;
import com.jlopez.clienteinfo.mapper.ClienteMapper;
import com.jlopez.clienteinfo.model.Cliente;
import com.jlopez.clienteinfo.service.impl.ClienteServiceImpl;

@SpringBootTest
class ClienteInfoControllerTest {

	@InjectMocks
	private ClienteController clienteController;

	@Mock
	private ClienteServiceImpl service;

	private MockMvc mockMvc;

	@BeforeEach
	void setup() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(clienteController).build();
	}

	@Test
	void getAll200Test() throws Exception {
		Optional<Cliente> clienteA = Optional.ofNullable(new Cliente());
		clienteA.get().setNombre("Juan");
		clienteA.get().setApellido("Perez");
		clienteA.get().setEdad(30);
		clienteA.get().setFechaNacimiento(LocalDate.parse("1991-01-10"));

		List<Cliente> clienteList = new ArrayList<>();
		clienteList.add(clienteA.get());

		List<ClienteResponse> responseList = clienteList.stream().map(ClienteMapper::clienteToClienteResponse)
				.collect(Collectors.toList());

		when(service.getAll()).thenReturn(responseList);
		mockMvc.perform(get("/api/cliente/listclientes/").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
	}

}

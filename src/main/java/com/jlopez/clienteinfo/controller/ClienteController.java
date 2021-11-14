package com.jlopez.clienteinfo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlopez.clienteinfo.dto.ClienteRequest;
import com.jlopez.clienteinfo.dto.ClienteResponse;
import com.jlopez.clienteinfo.dto.KPIResponse;
import com.jlopez.clienteinfo.service.ClienteService;

@RestController
@RequestMapping("/")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@PostMapping("/creacliente")
	public ResponseEntity<String> saveCliente(@RequestBody ClienteRequest clienteRequest) throws Exception {
		clienteService.saveCliente(clienteRequest);
		return new ResponseEntity<>("Created!", HttpStatus.CREATED);
	}

	@GetMapping("/kpideclientes")
	public ResponseEntity<KPIResponse> getKpiClientes() throws Exception {
		return new ResponseEntity<>(clienteService.getKPI(), HttpStatus.OK);
	}

	@GetMapping("/listclientes")
	public ResponseEntity<List<ClienteResponse>> getAll() throws Exception {
		return new ResponseEntity<>(clienteService.getAll(), HttpStatus.OK);
	}
}

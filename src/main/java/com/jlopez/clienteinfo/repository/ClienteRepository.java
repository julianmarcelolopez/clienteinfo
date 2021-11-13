package com.jlopez.clienteinfo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jlopez.clienteinfo.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	List<Cliente> findAll();
	
	public Cliente findByNombreAndApellido(String nombre, String apellido);
	
}

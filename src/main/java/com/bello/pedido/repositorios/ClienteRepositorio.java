package com.bello.pedido.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bello.pedido.entidades.Cliente;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

}
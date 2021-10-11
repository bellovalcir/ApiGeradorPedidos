package com.bello.pedido.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bello.pedido.entidades.Entrega;

public interface EntregaRepositorio extends JpaRepository<Entrega, Long> {

}
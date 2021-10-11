package com.bello.pedido.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bello.pedido.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
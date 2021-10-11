package com.bello.pedido.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bello.pedido.entidades.PedidoItens;

public interface PedidoItensRepositorio extends JpaRepository<PedidoItens, Long> {

}

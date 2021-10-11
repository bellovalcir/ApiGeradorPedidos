package com.bello.pedido.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bello.pedido.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {
}
package com.bello.pedido.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.bello.pedido.entidades.pk.PedidoItensPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_pedido_itens")
public class PedidoItens implements Serializable {
	private static final long serialVersionUID = 1L;
		
	@EmbeddedId
	private PedidoItensPK id = new PedidoItensPK();

	private Double valor;
	
	public PedidoItens() {
	}

	public PedidoItens(Pedido pedido, Produto produto, Double valor) {
		super();
		id.setPedido(pedido);
		id.setProduto(produto);
		this.valor = valor;
	}

	@JsonIgnore
	public Pedido getPedido() {
		return id.getPedido();
	}
	
	public void setPedido(Pedido pedido) {
		id.setPedido(pedido);
	}
	
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}
		
	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PedidoItens other = (PedidoItens) obj;
		return Objects.equals(id, other.id);
	}
}
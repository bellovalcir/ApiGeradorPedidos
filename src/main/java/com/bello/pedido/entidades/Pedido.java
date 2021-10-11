package com.bello.pedido.entidades;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_pedido")
public class Pedido implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private Cliente cliente;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<PedidoItens> items = new HashSet<>();
	
    public Pedido() {
    }

	public Pedido(Long id, Instant momento, String endereco, Cliente cliente, Set<PedidoItens> items) {
		super();
		this.id = id;
		this.momento = momento;
		this.endereco = endereco;
		this.cliente = cliente;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Set<PedidoItens> getItems() {
		return items;
	}

	public void setItems(Set<PedidoItens> items) {
		this.items = items;
	}

	public Double getTotal() {
		double sum = 0.0;
		for (PedidoItens x : items) {
			sum = sum + x.getValor();
		}
		return sum;
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
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}	
}
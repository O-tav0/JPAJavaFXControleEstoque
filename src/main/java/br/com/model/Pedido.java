package br.com.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_pedido;
	
	@OneToOne
	private Cliente cliente;
	
	private double valorTotal;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
	private List <ItemPedido> listaItens;
	
	public Pedido() {
		
	}
	
	

	public List<ItemPedido> getListaItens() {
		return listaItens;
	}



	public void setListaItens(List<ItemPedido> listaItens) {
		this.listaItens = listaItens;
	}



	public Pedido(Cliente cliente) {
		super();
		this.cliente = cliente;
	}

	public int getId_pedido() {
		return id_pedido;
	}

	public void setId_pedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	
	
}
	
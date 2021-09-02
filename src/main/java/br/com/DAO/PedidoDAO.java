package br.com.DAO;

import br.com.model.ItemPedido;
import br.com.model.Pedido;

public class PedidoDAO extends DAO {
	
	public void inserirItem(ItemPedido ip) {
		abrirT();
		em.persist(ip);
		fecharT();
	}
	
	public void inserirPedido(Pedido ped) {
		abrirT();
		em.persist(ped);
		fecharT();
	}
}

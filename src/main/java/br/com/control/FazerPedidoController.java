package br.com.control;

import java.util.ArrayList;

import br.com.DAO.ClienteDAO;
import br.com.DAO.PedidoDAO;
import br.com.DAO.ProdutoDAO;
import br.com.model.Cliente;
import br.com.model.ItemPedido;
import br.com.model.Pedido;
import br.com.model.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class FazerPedidoController {
	
	@FXML
	private TextField idClientePedido;
	
	@FXML
	private TextField idProdutoPedido;
	
	@FXML
	private TextField qtdProd;
	
	@FXML 
	Label labelQtdCarrinho;
	
	@FXML
	Label labelTotalCarrinho;
;
	
	
	
	private ArrayList<ItemPedido> itensDoPedido = new ArrayList<>();
	
	public void adicionarItemsPedido() {
		
		double valorCarrinho = 0.0;
		int codProduto = Integer.valueOf(idProdutoPedido.getText());
		int qtd = Integer.valueOf(qtdProd.getText());
		ProdutoDAO pdao = new ProdutoDAO();
		Produto prod = pdao.selecionarUm(codProduto);
		ItemPedido ip = new ItemPedido(prod, qtd);
		ip.setValorItem(qtd * prod.getValorProduto());
		itensDoPedido.add(ip);
		
		for(int k=0;k<itensDoPedido.size();k++) {
			valorCarrinho = valorCarrinho + itensDoPedido.get(k).getValorItem();
		}
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Produto inserido");
		alert.setHeaderText(null);
		alert.setContentText("O produto " + prod.getNomeProduto() + " foi inserido com sucesso");
		alert.showAndWait();
		
		idProdutoPedido.setText("");
		qtdProd.setText("");
		labelQtdCarrinho.setText(String.valueOf(itensDoPedido.size()));
		labelTotalCarrinho.setText(String.valueOf("R$ " + valorCarrinho));
		
	}
	
	public ArrayList<ItemPedido> getItensDoPedido() {
		return itensDoPedido;
	}

	public void realizarPedido() {
		
		ClienteDAO cdao =  new ClienteDAO();
		ProdutoDAO pdao = new ProdutoDAO();
		
		Cliente cli = cdao.selecionarUm(Integer.valueOf(idClientePedido.getText()));
			
		Pedido ped = new Pedido(cli);
		PedidoDAO pedDAO = new PedidoDAO();
		pedDAO.inserirPedido(ped);
		
		ped.setListaItens(itensDoPedido);
		
		double valorPedido=0.0;
		
		for(int j =0; j< itensDoPedido.size();j++) {
			valorPedido = valorPedido + itensDoPedido.get(j).getValorItem();
		}
		
		ped.setValorTotal(valorPedido);
		
		for(int i = 0; i< itensDoPedido.size();i++) {
			itensDoPedido.get(i).setPedido(ped);
			pedDAO.inserirItem(itensDoPedido.get(i));
		}
		
		pedDAO.inserirPedido(ped);
		
		pdao.abrirT();
		for(int i = 0; i< itensDoPedido.size();i++) {
			Produto prod = pdao.selecionarUm(itensDoPedido.get(i).getProduto().getId_produto());
			prod.setQtdEstoque(prod.getQtdEstoque() - itensDoPedido.get(i).getQtde());
		}
		pdao.fecharT();
		
		idClientePedido.setText("");
		idProdutoPedido.setText("");
		qtdProd.setText("");
		
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pedido finalizado");
		alert.setHeaderText(null);
		alert.setContentText("Pedido realizado com sucesso");
		alert.showAndWait();
		
		itensDoPedido.removeAll(itensDoPedido);
		labelTotalCarrinho.setText("0");
		labelQtdCarrinho.setText("0");
	}
}

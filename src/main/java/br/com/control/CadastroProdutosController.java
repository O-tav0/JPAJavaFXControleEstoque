package br.com.control;

import br.com.DAO.ProdutoDAO;
import br.com.model.Produto;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroProdutosController {
	@FXML
	private TextField campoNomeProd;
	
	@FXML
	private TextField campoValorProd;
	
	@FXML
	private TextField campoValorEstoque;
	
	
	public void cadastrarNovoProduto() {
		String nomeDigitado = campoNomeProd.getText();
		double valorDigitado = Double.valueOf(campoValorProd.getText().replace(",", "."));
		int estoqueDigitado = Integer.valueOf(campoValorEstoque.getText());
		
		Produto prod = new Produto(nomeDigitado, valorDigitado, estoqueDigitado);
		ProdutoDAO pdao =  new ProdutoDAO();
		pdao.inserirProduto(prod);
	}
}

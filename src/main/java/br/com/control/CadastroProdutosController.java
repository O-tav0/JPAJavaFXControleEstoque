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
	
	
	public void cadastrarNovoProduto() {
		String nomeDigitado = campoNomeProd.getText();
		double valorDigitado = Double.valueOf(campoValorProd.getText().replace(",", "."));
		
		Produto prod = new Produto(nomeDigitado, valorDigitado);
		ProdutoDAO pdao =  new ProdutoDAO();
		pdao.inserirProduto(prod);
	}
}

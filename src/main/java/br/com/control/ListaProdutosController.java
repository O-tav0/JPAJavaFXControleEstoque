package br.com.control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.DAO.ProdutoDAO;
import br.com.model.Produto;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListaProdutosController implements Initializable {

	@FXML
	private TableView<ProdutoTabela> tabelaProd;

	@FXML
	private TableColumn<ProdutoTabela, String> colunaNome;

	@FXML
	private TableColumn<ProdutoTabela, Integer> colunaValor;
	@FXML
	private TableColumn<ProdutoTabela, Integer> colunaCodigo;

	@FXML
	private TextField idDeletarProduto;

	@FXML
	private TextField novoNome;

	@FXML
	private TextField novoValor;

	@FXML
	private TextField idAlterarProduto;

	public void deletarProduto() {
		int codigo = Integer.valueOf(idDeletarProduto.getText());
		ProdutoDAO pdao = new ProdutoDAO();
		pdao.deletar(codigo);
		tabelaProd.setItems(ObterlistaProdutos());
		idDeletarProduto.setText("");
	}

	public void selecionarProduto() {
		int codigo = Integer.valueOf(idAlterarProduto.getText());
		ProdutoDAO pdao = new ProdutoDAO();
		Produto prod = pdao.selecionarUm(codigo);

		novoNome.setText(prod.getNomeProduto());
		novoValor.setText(String.valueOf(prod.getValorProduto()));
	}

	public void alterarProdutos() {
		ProdutoDAO pdao = new ProdutoDAO();

		int codigoAlt = Integer.valueOf(idAlterarProduto.getText());
		Double valorDigitado = Double.valueOf(novoValor.getText().replace(",", "."));
		String nomeDigitado = novoNome.getText();

		Produto prod = pdao.selecionarUm(codigoAlt);
		pdao.alterar( prod, codigoAlt, nomeDigitado, valorDigitado);

		tabelaProd.setItems(ObterlistaProdutos());
		idAlterarProduto.setText("");
		novoNome.setText("");
		novoValor.setText("");
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		colunaValor.setCellValueFactory(new PropertyValueFactory<>("idade"));

		tabelaProd.setItems(ObterlistaProdutos());
	}

	private ObservableList<ProdutoTabela> ObterlistaProdutos() {
		ProdutoDAO pdao = new ProdutoDAO();
		List<Produto> listaDoBanco = pdao.listarTodos();
		ObservableList<ProdutoTabela> list = FXCollections.observableArrayList();
		for (int i = 0; i < listaDoBanco.size(); i++) {
			Produto prod = listaDoBanco.get(i);
			ProdutoTabela prodT = new ProdutoTabela(prod.getId_produto(), prod.getNomeProduto(),
					prod.getValorProduto());
			list.add(prodT);
		}
		return list;
	}

	public static class ProdutoTabela {
		private SimpleIntegerProperty id;
		private SimpleDoubleProperty valor;
		private SimpleStringProperty nome;

		public ProdutoTabela(Integer id, String nome, Double valor) {
			this.id = new SimpleIntegerProperty(id);
			this.nome = new SimpleStringProperty(nome);
			this.valor = new SimpleDoubleProperty(valor);
		}

		public String getNome() {
			return nome.get();
		}

		public int getId() {
			return id.get();
		}

		public void setId(SimpleIntegerProperty id) {
			this.id = id;
		}

		public void setNome(SimpleStringProperty nome) {
			this.nome = nome;
		}

		public void setValor(SimpleDoubleProperty valor) {
			this.valor = valor;
		}

		public double getIdade() {
			return valor.get();
		}

	}
}

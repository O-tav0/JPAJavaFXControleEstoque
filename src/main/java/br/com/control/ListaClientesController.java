package br.com.control;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.com.DAO.ClienteDAO;
import br.com.DAO.ProdutoDAO;
import br.com.model.Cliente;
import br.com.model.Produto;
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

public class ListaClientesController implements Initializable {
	
	@FXML
	private TableView<ClienteTabela> tabelaCli;
	
	@FXML
	private TableColumn<ClienteTabela, String> colunaNome;
	
	@FXML
	private TableColumn<ClienteTabela, Integer> colunaIdade;
	
	@FXML
	private TableColumn<ClienteTabela, Integer> colunaCodigo;
	
	@FXML
	private TextField idDeletarCliente;
	
	@FXML
	private TextField novoNome;
	
	@FXML
	private TextField novaIdade;
	
	@FXML
	private TextField idAlterarCliente;
	
	public void deletarCliente() {
		int codigo = Integer.valueOf(idDeletarCliente.getText());
		ClienteDAO cdao = new ClienteDAO();
		cdao.deletar(codigo);
		tabelaCli.setItems(ObterlistaClientes());
		idDeletarCliente.setText("");
	}
	
	public void selecionarCliente() {
		int codigo = Integer.valueOf(idAlterarCliente.getText());
		ClienteDAO cdao = new ClienteDAO();
		Cliente cli = cdao.selecionarUm(codigo);

		novoNome.setText(cli.getNomeCliente());
		novaIdade.setText(String.valueOf(cli.getIdadeCliente()));
	}
	
	public void alterarCliente() {
		int codigoAlt = Integer.valueOf(idAlterarCliente.getText());
		String nomeDigitado = novoNome.getText();
		Integer idadeDigitada = Integer.valueOf(novaIdade.getText());
		ClienteDAO cdao = new ClienteDAO();
		
		Cliente cli = cdao.selecionarUm(codigoAlt);
		
		cdao.alterar(cli, codigoAlt, nomeDigitado, idadeDigitada);
		
		tabelaCli.setItems(ObterlistaClientes());
		idAlterarCliente.setText("");
		novoNome.setText("");
		novaIdade.setText("");
	}
	
	@Override
    public void initialize(URL location, ResourceBundle resources) {
		colunaCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
		colunaNome.setCellValueFactory(
                new PropertyValueFactory<>("nome"));
        colunaIdade.setCellValueFactory(
                new PropertyValueFactory<>("idade"));
        
        tabelaCli.setItems(ObterlistaClientes());
    }
	
	private ObservableList<ClienteTabela> ObterlistaClientes() {
		ClienteDAO cdao = new ClienteDAO();   
		List<Cliente> listaDoBanco = cdao.listarTodos();
		ObservableList<ClienteTabela> list = FXCollections.observableArrayList();
		for(int i=0; i<listaDoBanco.size();i++) {
        	Cliente cli = listaDoBanco.get(i);
			ClienteTabela cliT = new ClienteTabela(cli.getId_cliente(), cli.getNomeCliente(), cli.getIdadeCliente());
			list.add(cliT);
		}
		return list;
		}
					   
	
	public static class ClienteTabela {
		private SimpleIntegerProperty id;
		private SimpleIntegerProperty idade;
	    private SimpleStringProperty nome;
	    
	    public ClienteTabela(Integer id, String nome, Integer idade) {
	    	this.id = new SimpleIntegerProperty(id);
	        this.nome = new SimpleStringProperty(nome);
	        this.idade = new SimpleIntegerProperty(idade);
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

		public void setIdade(SimpleIntegerProperty idade) {
			this.idade = idade;
		}

		public int getIdade() {
	        return idade.get();
	    }
	    
	}
}


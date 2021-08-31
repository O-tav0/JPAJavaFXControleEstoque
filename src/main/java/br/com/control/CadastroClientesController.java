package br.com.control;

import br.com.DAO.ClienteDAO;
import br.com.model.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CadastroClientesController {
	
	@FXML
	private TextField campoNomeCliente;
	
	@FXML
	private TextField campoIdadeCliente;
	
	
	public void cadastrarNovoCliente() {
		String nomeDigitado = campoNomeCliente.getText();
		int idadeDigitada = Integer.valueOf(campoIdadeCliente.getText());
		
		Cliente cli = new Cliente(nomeDigitado, idadeDigitada);
		ClienteDAO pdao = new ClienteDAO();
		pdao.inserirCliente(cli);
	}
}

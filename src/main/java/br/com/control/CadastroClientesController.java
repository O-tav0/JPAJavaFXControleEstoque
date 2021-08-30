package br.com.control;

import br.com.model.Cliente;
import javafx.scene.control.TextField;

public class CadastroClientesController {
	private TextField campoNomeCliente;
	private TextField campoIdadeCliente;
	
	
	public void cadastrarNovoCliente() {
		String nomeDigitado = campoNomeCliente.getText();
		int idadeDigitada = Integer.valueOf(campoIdadeCliente.getText());
		
		Cliente cli = new Cliente(nomeDigitado, idadeDigitada);
		
		
	}
}

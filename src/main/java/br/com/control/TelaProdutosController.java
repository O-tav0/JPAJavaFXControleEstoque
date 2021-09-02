package br.com.control;

import java.io.IOException;
import java.net.URL;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaProdutosController {
	
	public void mostrarTelaCadastroProdutos() throws IOException {
		Stage cadastroProdutosStage = new Stage();
		//TelaClientes telaCli = new TelaClientes();
		
		String arquivoCSS = getClass().getResource("/br/com/view/TelaProdutos.css").toExternalForm();
		URL arquivoFxml = getClass().getResource("/br/com/view/CadastroProdutos.fxml");
		GridPane cenaClientes = FXMLLoader.load(arquivoFxml);
		
		Scene cenaCli = new Scene(cenaClientes, 800, 600);
		cenaCli.getStylesheets().add(arquivoCSS);
		cadastroProdutosStage.setResizable(false);
		cadastroProdutosStage.setTitle("Cadastro de Produtos");
		cadastroProdutosStage.setScene(cenaCli);
		cadastroProdutosStage.show();
		
		//Caso queira utilizar a mesma tela(Stage)
		
//		TelaClientes telaCli = new TelaClientes();
//		URL FXMLTelaClientes = getClass().getResource("/br/com/view/TelaClientes.fxml");
//		GridPane cenaCliente = FXMLLoader.load(FXMLTelaClientes);
//		Tela.getChildren().setAll(cenaCliente);
	}
	
	public void mostrarTelaListagemProdutos() throws IOException {
		Stage telaListagemStage = new Stage();
		
		String arquivoCSS = getClass().getResource("/br/com/view/TelaProdutos.css").toExternalForm();
		URL arquivoFxml = getClass().getResource("/br/com/view/ListaProdutos.fxml");
		GridPane cenaClientes = FXMLLoader.load(arquivoFxml);
		
		Scene cenaListagem = new Scene(cenaClientes, 800, 600);
		cenaListagem.getStylesheets().add(arquivoCSS);
		telaListagemStage.setResizable(false);
		telaListagemStage.setTitle("Listagem de Produtos");
		telaListagemStage.setScene(cenaListagem);
		telaListagemStage.show();
		
	}
}

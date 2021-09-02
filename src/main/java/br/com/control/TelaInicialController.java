package br.com.control;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import br.com.model.ItemPedido;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaInicialController {
	
	@FXML
	private GridPane Tela;
	
	@FXML
	public void mostrarTelaClientes() throws IOException {
		Stage clientesStage = new Stage();
		//TelaClientes telaCli = new TelaClientes();
		
		URL arquivoFxml = getClass().getResource("/br/com/view/TelaClientes.fxml");
		String arquivoCSS = getClass().getResource("/br/com/view/TelaClientes.css").toExternalForm();
		GridPane cenaClientes = FXMLLoader.load(arquivoFxml);
		
		Scene cenaCli = new Scene(cenaClientes, 800, 600);
		cenaCli.getStylesheets().add(arquivoCSS);
		clientesStage.setResizable(false);
		clientesStage.setTitle("Tela de Clientes");
		clientesStage.setScene(cenaCli);
		clientesStage.show();
		
		//Caso queira utilizar a mesma tela(Stage)
		
//		TelaClientes telaCli = new TelaClientes();
//		URL FXMLTelaClientes = getClass().getResource("/br/com/view/TelaClientes.fxml");
//		GridPane cenaCliente = FXMLLoader.load(FXMLTelaClientes);
//		Tela.getChildren().setAll(cenaCliente);
	}
	
	public void mostrarTelaProdutos() throws IOException {
			Stage produtoStage = new Stage();
			//TelaClientes telaCli = new TelaClientes();
			
			URL arquivoFxml = getClass().getResource("/br/com/view/TelaProdutos.fxml");
			String arquivoCSS = getClass().getResource("/br/com/view/TelaProdutos.css").toExternalForm();
			GridPane cenaProduto = FXMLLoader.load(arquivoFxml);
			
			Scene cenaCli = new Scene(cenaProduto, 800, 600);
			cenaCli.getStylesheets().add(arquivoCSS);
			produtoStage.setResizable(false);
			produtoStage.setTitle("Tela de Produtos");
			produtoStage.setScene(cenaCli);
			produtoStage.show();
	}
	
	public void mostrarTelaPedido() throws IOException {
		Stage pedidoStage = new Stage();
		
		URL arquivoFxml = getClass().getResource("/br/com/view/FazerPedido.fxml");
		String arquivoCSS = getClass().getResource("/br/com/view/TelaPedidos.css").toExternalForm();
		GridPane cenaProduto = FXMLLoader.load(arquivoFxml);
		
		Scene cenaCli = new Scene(cenaProduto, 800, 600);
		cenaCli.getStylesheets().add(arquivoCSS);
		pedidoStage.setResizable(false);
		pedidoStage.setTitle("Pedidos");
		pedidoStage.setScene(cenaCli);
		pedidoStage.show();
	}
}

package br.com.control;

import java.io.IOException;
import java.net.URL;
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
		GridPane cenaClientes = FXMLLoader.load(arquivoFxml);
		
		Scene cenaCli = new Scene(cenaClientes, 800, 600);
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
}

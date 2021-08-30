package br.com.view;

import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaClientes extends Application{
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL arquivoFxml = getClass().getResource("/br/com/view/TelaClientes.fxml");
		GridPane cenaClientes = FXMLLoader.load(arquivoFxml);
		
		Scene cenaCli = new Scene(cenaClientes, 800, 600);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tela de Clientes");
		primaryStage.setScene(cenaCli);
		primaryStage.show();
	}
}

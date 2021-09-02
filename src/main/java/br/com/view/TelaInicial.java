package br.com.view;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaInicial extends Application{
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		URL arquivoFxml = getClass().getResource("/br/com/view/TelaInicial.fxml");
		String arquivoCSS = getClass().getResource("/br/com/view/TelaInicial.css").toExternalForm();
		GridPane cenaInicial = FXMLLoader.load(arquivoFxml);
		
		Scene cenaAtual = new Scene(cenaInicial, 800, 600);
		cenaAtual.getStylesheets().add(arquivoCSS);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Tela Inicial");
		primaryStage.setScene(cenaAtual);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}	

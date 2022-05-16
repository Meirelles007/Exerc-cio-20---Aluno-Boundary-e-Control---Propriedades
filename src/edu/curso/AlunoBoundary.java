package edu.curso;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class AlunoBoundary extends Application {

	private TextField txtID = new TextField();
	private TextField txtRA = new TextField();
	private TextField txtNome = new TextField();
	private TextField txtNascimento = new TextField();
	private Button btnAdicionar = new Button("Adicionar");
	private Button btnPesquisar = new Button("Pesquisar");
	private AlunoControl control = new AlunoControl();

	public void start(Stage stage) throws Exception {
		GridPane pane = new GridPane();
		Scene snc = new Scene(pane, 300, 200);

		pane.setHgap(5);
		pane.add(new Label("Id:"), 0, 0);
		pane.add(txtID, 1, 0);
		pane.add(new Label("Ra:"), 0, 1);
		pane.add(txtRA, 1, 1);
		pane.add(new Label("Nome:"), 0, 2);
		pane.add(txtNome, 1, 2);
		pane.add(new Label("Nascimento:"), 0, 3);
		pane.add(txtNascimento, 1, 3);
		pane.add(btnAdicionar, 0, 4);
		pane.add(btnPesquisar, 1, 4);

		Bindings.bindBidirectional(txtID.textProperty(), control.idProperty());
		Bindings.bindBidirectional(txtRA.textProperty(), control.raProperty());
		Bindings.bindBidirectional(txtNome.textProperty(), control.nomeProperty());
		Bindings.bindBidirectional(txtNascimento.textProperty(), control.dataProperty());

		btnAdicionar.setOnAction((e) -> {
			control.adicionar();
		});

		btnPesquisar.setOnAction((e) -> {
			control.pesquisar();
		});

		stage.setScene(snc);
		stage.setTitle("Gestão de Alunos");
		stage.show();
	}

	public static void main(String[] args) {
		Application.launch(AlunoBoundary.class, args);
	}

}

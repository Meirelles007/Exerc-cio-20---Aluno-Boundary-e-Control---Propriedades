package edu.curso;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AlunoControl {
	private Aluno[] lista = new Aluno[100];
	private int indice = 0;
	StringProperty id = new SimpleStringProperty();
	StringProperty ra = new SimpleStringProperty();
	StringProperty nome = new SimpleStringProperty();
	StringProperty data = new SimpleStringProperty();

	public StringProperty idProperty() {
		return id;
	}

	public StringProperty raProperty() {
		return ra;
	}

	public StringProperty nomeProperty() {
		return nome;
	}

	public StringProperty dataProperty() {

		return data;
	}

	public Aluno boundaryToEntity() {
		Aluno a = new Aluno();
		a.setId(Integer.parseInt(id.get()));
		a.setRa(Long.parseLong(ra.get()));
		a.setNome(nome.get());
		a.setNascimento(data.get());

		return a;
	}

	public void entityToBoundary(Aluno a) {
		if (a != null) {
			id.set(String.valueOf(a.getId()));
			ra.set(String.valueOf(a.getRa()));
			nome.set(a.getNome());
			data.set(a.getNascimento());
		}
	}

	public void adicionar() {
		lista[indice++] = boundaryToEntity();
	}

	public void pesquisar() {
		for (int i = 0; i < indice; i++) {
			Aluno a = lista[i];
			if (a != null && a.getNome() != null && a.getNome().contains(nome.get())) {
				entityToBoundary(a);
			}
		}
	}

}
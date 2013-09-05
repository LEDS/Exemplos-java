package br.edu.ifes.poo2.db.model;

import br.edu.ifes.poo2.db.model.reuse.Model;


public class Usuario extends Model{

	private String nome;

	private String senha;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}

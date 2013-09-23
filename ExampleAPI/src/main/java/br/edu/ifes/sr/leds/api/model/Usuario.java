package br.edu.ifes.sr.leds.api.model;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Model{

	private String email;

	private String senha;
	
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	
}

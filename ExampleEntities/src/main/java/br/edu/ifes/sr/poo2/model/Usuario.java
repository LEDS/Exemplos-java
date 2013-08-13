package br.edu.ifes.sr.poo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Usuario extends Model{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column
	private String email;
	
	@Column
	private String senha;

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

package br.edu.ifes.sr.poo2.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

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
	
	@Column
	private String nome;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Endereco> enderecos = new HashSet<Endereco>();

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Set<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(Set<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	public void add(Endereco endereco)
	{
		enderecos.add(endereco);
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

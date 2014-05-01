package br.edu.ifes.sr.poo2.model.view;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Id;

@Entity
@Table(name="usuarionomeview")
public class UsuarioDTO {
	
	@Id
	@Column
	private Long id;
	
	@Column
	private String nome;
	
	


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


		
	
}

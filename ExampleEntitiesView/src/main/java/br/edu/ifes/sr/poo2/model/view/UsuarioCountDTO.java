package br.edu.ifes.sr.poo2.model.view;

public class UsuarioCountDTO {
	
	public Long value;
	
	public String nome;

	public UsuarioCountDTO(){}
	
	public UsuarioCountDTO(Long value, String nome) {
		super();
		this.value = value;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	
	public String toString()
	{
		return "nome: "+nome+" | count: "+value;
	}
}

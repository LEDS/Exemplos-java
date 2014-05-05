package br.edu.ifes.sr.poo2.model.view;

public class UsuarioDTO {
	
	private Long id;
	
	private String nome;
	
	public UsuarioDTO()
	{
		
	}
	
	public UsuarioDTO(Long id, String nome)
	{
		this.id = id;
		this.nome = nome;
	}
	
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

	public String toString()
	{
		return nome +" | "+id;
	}
}

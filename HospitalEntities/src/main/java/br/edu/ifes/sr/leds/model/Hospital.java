package br.edu.ifes.sr.leds.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Hospital implements Serializable{
	
	@Id
	@Column (name="hospitalID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	@Column
	private String nome;
	
	@ManyToMany
	@JoinTable(
			name="Hospital_Setor",
			joinColumns={@JoinColumn(name="hospitalID")},
			inverseJoinColumns={@JoinColumn(name="setorID")}
			)	
	private Set <Setor> setores = new HashSet<Setor>(); 

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Setor> getSetores() {
		return setores;
	}

	public void setSetores(Set<Setor> setores) {
		this.setores = setores;
	}
		
	public void adicionarSetor (Setor setor)
	{
		this.setores.add(setor);
	}
	
}

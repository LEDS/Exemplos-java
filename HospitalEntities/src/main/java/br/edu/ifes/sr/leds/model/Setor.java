package br.edu.ifes.sr.leds.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Setor implements Serializable{
	
	@Id
	@Column (name="setorID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToMany
	Set<Hospital> hospital = new HashSet<Hospital>();
	
	public Set<Hospital> getHospital() {
		return hospital;
	}

	public void setHospital(Set<Hospital> hospital) {
		this.hospital = hospital;
	}

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
	
	public void adicionarHospital (Hospital hospital)
	{
		this.hospital.add(hospital);
	}
	
}

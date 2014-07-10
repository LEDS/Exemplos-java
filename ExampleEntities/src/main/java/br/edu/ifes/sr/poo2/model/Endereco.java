package br.edu.ifes.sr.poo2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Endereco extends AbstractPersistable <Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Version
	
	private long version;
	
	@Column
	private String logradouro;
	@Column
	private String endereco;
	@Column
	private String numero;

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	

}

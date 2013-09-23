package br.edu.ifes.sr.leds.api.model;


public class Endereco extends Model {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String logradouro;
	
	private String endereco;
	
	private String numero;

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

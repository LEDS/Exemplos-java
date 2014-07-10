package br.edu.ifes.sr.poo2.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
@Table(name = "USUARIO")

public class Usuario extends AbstractPersistable <Long>{
	
	private static final long serialVersionUID = 1L;
	
	@Version
	@Column(name = "VERSION")
	private long version;

	@Column(name = "LOGIN", length = 30, nullable = false, unique = true)
    private String login;
	
	@Column(length = 30, nullable = false, unique = true)
	private String email;
	
	@Column(length = 6, nullable = false, unique = false)
	private String senha;
	
	@Column(name = "NOME", nullable = false, unique = false)
	private String nome;
	
	@Column(name = "DATA_CADASTRO", nullable = false, unique = false)
    @Temporal(value = TemporalType.TIMESTAMP)
	private Date dtCadastro;
	
	@Column(name = "IDADE", nullable = false, unique = false)
	private int idade;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Endereco> enderecos = new HashSet<Endereco>();

	public String getNome() {
		return nome;
	}


	public long getVersion() {
		return version;
	}


	public void setVersion(long version) {
		this.version = version;
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


	public Date getDtCadastro() {
		return dtCadastro;
	}


	public void setDtCadastro(Date dtCadastro) {
		this.dtCadastro = dtCadastro;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}
	
}

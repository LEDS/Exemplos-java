package br.edu.ifes.sr.teste;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Endereco;
import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.service.UsuarioService;

public class TestService extends AbstractTest {

	@Autowired
	UsuarioService usuarioService;

	private Usuario usuario;
	
	private Endereco endereco;
	
	@Before
	public void before()
	{
		usuario = new Usuario();
		usuario.setEmail("paulossjunior@gmail.com");
		usuario.setSenha("1234");
		usuario.setNome("Paulo");
		usuario.setDtCadastro(new Date());
		usuario.setIdade(30);
		usuario.setLogin("paulossjunior");
		
		endereco = new Endereco();
		endereco.setLogradouro("Rua");
		endereco.setEndereco("Rua X");
		endereco.setNumero("10");
		
		usuario.add(endereco);
		
	}
	
	
	@Test
	public void salvar(){
			
		usuarioService.save(usuario);
		Assert.assertNotSame(usuario.getId(), 0);
	}
	
	@Test
	public void update(){
		
		usuarioService.save(usuario);
		long oldVersion = usuario.getVersion();
		System.out.println("Salvando:"+usuario.getVersion());
		
		usuario.setNome("João Paulo");
		
		usuarioService.update(usuario);
		System.out.println("Atualizado:"+usuario.getVersion());
		Assert.assertNotSame(usuario.getVersion(), oldVersion);
	}
	
	@Test
	public void findByEmail(){
		
		usuarioService.save(usuario);
		
		Usuario x = usuarioService.findByEmail("paulossjunior@gmail.com");
		
		Assert.assertNotNull(x);
		
	}
	
}

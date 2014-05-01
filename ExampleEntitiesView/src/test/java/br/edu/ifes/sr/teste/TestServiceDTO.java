package br.edu.ifes.sr.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Endereco;
import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.model.view.UsuarioDTO;
import br.edu.ifes.sr.poo2.service.UsuarioDTOService;
import br.edu.ifes.sr.poo2.service.UsuarioService;

public class TestServiceDTO extends AbstractTest {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	UsuarioDTOService usuarioDTOService;
	
	private Usuario usuario;
	
	private Endereco endereco;
	
	@Before
	public void before()
	{
		usuario = new Usuario();
		usuario.setEmail("paulossjunior@gmail.com");
		usuario.setSenha("1234");
		usuario.setNome("Paulo");
		
		endereco = new Endereco();
		endereco.setLogradouro("Rua");
		endereco.setEndereco("Rua X");
		endereco.setNumero("10");
		
		usuario.add(endereco);
		
	}
	
	@Test
	public void buscarUsuariosView(){
		
		usuarioService.save(usuario);
		
		Assert.assertNotSame(usuario.getId(), 0);
		
		Iterable<UsuarioDTO> usuarios = usuarioDTOService.findAll();
		
		Assert.assertNotNull(usuarios);
		
		for (UsuarioDTO usuarioDTO: usuarios){
				System.out.println("Nome: "+usuarioDTO.getNome());
		}
		
		
		
	}
	

	
}

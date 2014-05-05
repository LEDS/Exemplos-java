package br.edu.ifes.sr.teste;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Endereco;
import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.model.view.UsuarioCountDTO;
import br.edu.ifes.sr.poo2.model.view.UsuarioDTO;
import br.edu.ifes.sr.poo2.service.UsuarioService;

public class TestServiceDTO extends AbstractTest {

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
		
		endereco = new Endereco();
		endereco.setLogradouro("Rua");
		endereco.setEndereco("Rua X");
		endereco.setNumero("10");
		usuario.add(endereco);
		
	}
	
	
	
	@Test
	public void executarAggregationFunction()
	{
		usuarioService.save(usuario);
		
		Assert.assertNotSame(usuario.getId(), 0);
		
		List<UsuarioCountDTO> UsuariosCountDTO = usuarioService.aggregationFunction();
		
		Assert.assertNotNull(UsuariosCountDTO);
		
		for (UsuarioCountDTO usuarioCountDTO: UsuariosCountDTO)
		{
			System.out.println(usuarioCountDTO);
		}
		
	}
	@Test
	public void executarView()
	{
		List<UsuarioDTO> UsuarioDTOS = (List<UsuarioDTO>)usuarioService.sampleQuery();
		Assert.assertNotNull(UsuarioDTOS);
	}
	

	
}

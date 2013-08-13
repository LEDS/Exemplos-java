package br.edu.ifes.sr.teste;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.service.UsuarioService;

public class TestService extends AbstractTest {

	@Autowired
	UsuarioService usuarioService;

	@Test
	public void salvar(){
		
		Usuario usuario = new Usuario();
		usuario.setEmail("paulossjunior@gmail.com");
		usuario.setSenha("1234");
		usuarioService.save(usuario);
		Assert.assertNotSame(usuario.getId(), 0);
	}
	
	@Test
	public void find(){
		
		Usuario usuario = new Usuario();
		usuario.setEmail("paulossjunior@gmail.com");
		usuario.setSenha("1234");
		usuarioService.save(usuario);
		
		Usuario x = usuarioService.findByEmail("paulossjunior@gmail.com");
		Assert.assertNotNull(x);
		
		
		
	}
}

package br.edu.ifes.sr.teste;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.repository.UsuarioRepository;

public class TesteJPA extends AbstractTest{
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void salvar(){
		
		Usuario usuario = new Usuario();
		usuario.setEmail("paulossjunior@gmail.com");
		usuario.setSenha("1234");
		usuarioRepository.save(usuario);
		Assert.assertNotSame(0, usuario.getId());
		System.out.println(usuario.getId());
	}
	
	@Test
	public void find(){
		
		Usuario usuario = new Usuario();
		usuario.setEmail("paulossjunior@gmail.com");
		usuario.setSenha("1234");
		usuarioRepository.save(usuario);
		
		Usuario usuarioX = usuarioRepository.findByEmail("paulossjunior@gmail.com");
		
		Assert.assertNotNull(usuarioX);
		
	}

}

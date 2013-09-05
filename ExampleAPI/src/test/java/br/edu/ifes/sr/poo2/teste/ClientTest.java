package br.edu.ifes.sr.poo2.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifes.sr.leds.api.ExampleAPI;
import br.edu.ifes.sr.leds.api.ExampleAPIImpl;
import br.edu.ifes.sr.leds.api.model.Usuario;

public class ClientTest {
	
	private ExampleAPI exampleAPI;
	private Usuario usuario;
	
	@Before
	public void before(){
		
		exampleAPI = new ExampleAPIImpl();
		
		usuario = new Usuario();
		usuario.setEmail(UUID.randomUUID().toString());
		usuario.setSenha(UUID.randomUUID().toString());
	}
	
	
	@Test
	public void isWorking()
	{
		boolean resposta = exampleAPI.isWorking();
		
		Assert.assertTrue(resposta);
		
	}
	
	@Test
	public void count()
	{
		Long resposta = exampleAPI.count();
		
		System.out.println(resposta);
		
	}
	
	@Test
	public void adicionarUsuario()
	{
		
		int id = exampleAPI.adicionarUsuario(usuario);
		
		System.out.println("ID do novo usuario"+id);
		
	}
	@Test
	public void getUsuario()
	{
		int id = exampleAPI.adicionarUsuario(usuario);
		
		Usuario usuarioX = exampleAPI.getUsuario(id);
		
		System.out.println("Email: "+usuarioX.getEmail());
		System.out.println("Senha: "+usuarioX.getSenha());
		
		
	}
	
	@Test
	public void list()
	{
		List<String> lista = new ArrayList<String>();
		
		lista.add("XXX");
		lista.add("YYY");
		
		Assert.assertTrue(exampleAPI.isWorkingList(lista));
	}

}

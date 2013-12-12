package br.edu.ifes.sr.teste;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.leds.model.Setor;
import br.edu.ifes.sr.leds.service.SetorService;

public class SetorTest extends AbstractTest {

	@Autowired
	SetorService service;

	private Setor setor;
	
	@Before
	public void before()
	{
		setor = new Setor();
		setor.setNome(UUID.randomUUID().toString());
	}
	@Test
	public void salvar()
	{
		service.save(setor);
		Assert.assertNotSame(0,setor.getId());
	}
	
		
}

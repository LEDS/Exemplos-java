package br.edu.ifes.sr.teste;

import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.leds.model.Hospital;
import br.edu.ifes.sr.leds.service.HospitalService;

public class HospitalTest extends AbstractTest {

	@Autowired
	HospitalService service;

	private Hospital hospital;
	
	@Before
	public void before()
	{
		hospital = new Hospital();
		hospital.setNome(UUID.randomUUID().toString());
	}
	@Test
	public void salvar()
	{
		service.save(hospital);
		Assert.assertNotSame(0,hospital.getId());
	}
	
		
}

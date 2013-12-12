package br.edu.ifes.sr.teste;

import java.util.Iterator;
import java.util.UUID;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifes.sr.leds.model.Hospital;
import br.edu.ifes.sr.leds.model.Setor;
import br.edu.ifes.sr.leds.service.HospitalService;
import br.edu.ifes.sr.leds.service.SetorService;

public class SetorHospitalTest extends AbstractTest {

	@Autowired
	SetorService setorService;

	@Autowired
	HospitalService hospitalService;
	
	private Setor setor;
	
	private Hospital hospital;
	
	private String nomeHospital;
	
	private String nomeSetor;
	
	@Before
	public void before()
	{
		nomeSetor = UUID.randomUUID().toString();
		nomeHospital = UUID.randomUUID().toString();
		
		setor = new Setor();
		setor.setNome(nomeSetor);
		
		hospital = new Hospital();
		hospital.setNome(nomeHospital);
	}
	@Test
	public void salvar()
	{
		/* Salvando os setor e o Hospital */
		setorService.save(setor);
		Assert.assertNotSame(0,setor.getId());
		
		hospitalService.save(hospital);
		Assert.assertNotSame(0,hospital.getId());
		
		/* Adicionando um Setor a um Hospital*/
		hospital.adicionarSetor(setor);
		hospitalService.save(hospital);
		
		//Adicionando o Hospital no Setor
		setor.adicionarHospital(hospital);
		setorService.save(setor);
		
		//recuperando o hospital
		Hospital novoHospital = hospitalService.get(hospital.getId());
		
		//Verificando se o hospital possui um setor
		Assert.assertNotSame(0, novoHospital.getSetores().size());
		
		Setor novoSetor = setorService.get(setor.getId());
		Assert.assertNotSame(0, novoSetor.getHospital().size());
		
	}
	
	@Test
	public void buscaSetorPorHospital()
	{
		/* Salvando os setor e o Hospital */
		setorService.save(setor);
		Assert.assertNotSame(0,setor.getId());
		
		hospitalService.save(hospital);
		Assert.assertNotSame(0,hospital.getId());
		
		/* Adicionando um Setor a um Hospital*/
		hospital.adicionarSetor(setor);
		hospitalService.save(hospital);
		
		//Adicionando o Hospital no Setor
		setor.adicionarHospital(hospital);
		setorService.save(setor);
		
		//recuperando o hospital
		Hospital novoHospital = hospitalService.get(hospital.getId());
		
		//Buscando o setor X
		Setor novoSetor = setorService.get(setor.getId());
		Assert.assertNotSame(0, novoSetor.getHospital().size());
		
		//Verificando se o hospital possui um setor
		Assert.assertNotSame(0, novoHospital.getSetores().size());

		//Verificando se o nome do setor salvo eh o mesmo, assumindo que apenas cadastramos um setor por hospital 
		
		Iterator<Setor> setores = novoHospital.getSetores().iterator();
		while (setores.hasNext())
		{
			Setor setorX = setores.next();
			Assert.assertSame(nomeSetor, setorX.getNome());	
		}
		
		
		
	}
	
	@Test
	public void buscaHospitalPorSetor()
	{
		/* Salvando os setor e o Hospital */
		setorService.save(setor);
		Assert.assertNotSame(0,setor.getId());
		
		hospitalService.save(hospital);
		Assert.assertNotSame(0,hospital.getId());
		
		/* Adicionando um Setor a um Hospital*/
		hospital.adicionarSetor(setor);
		hospitalService.save(hospital);
		
		//Adicionando o Hospital no Setor
		setor.adicionarHospital(hospital);
		setorService.save(setor);
		
		//recuperando o setor
		Setor novoSetor = setorService.get(setor.getId());
		
		//Verificando se o setor possui pelo menos um hospital
		Assert.assertNotSame(0, novoSetor.getHospital().size());

		//Verificando se o nome do hospital salvo eh o mesmo, assumindo que apenas cadastramos um hospital por setor 
		
		Iterator<Hospital> hospitais = novoSetor.getHospital().iterator();
		while (hospitais.hasNext())
		{
			Hospital hospitalX = hospitais.next();
			Assert.assertSame(nomeHospital, hospitalX.getNome());	
		}
		
	}
		
}

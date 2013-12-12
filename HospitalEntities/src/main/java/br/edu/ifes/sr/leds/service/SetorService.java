package br.edu.ifes.sr.leds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.leds.model.Hospital;
import br.edu.ifes.sr.leds.model.Setor;
import br.edu.ifes.sr.leds.repository.HospitalRepository;
import br.edu.ifes.sr.leds.repository.SetorRepository;

@Service
public class SetorService implements CRUDService<Long, Setor> {

	@Autowired
	SetorRepository repository;
	
		public void save(Setor t) {
			repository.save(t);
		
	}

	public List<Setor> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		repository.delete(id);
		
	}

	public Setor get(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	public long count() {
		// TODO Auto-generated method stub
		return repository.count();
	}
	
}

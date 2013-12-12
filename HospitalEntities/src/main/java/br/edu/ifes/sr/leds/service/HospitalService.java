package br.edu.ifes.sr.leds.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.leds.model.Hospital;
import br.edu.ifes.sr.leds.repository.HospitalRepository;

@Service
public class HospitalService implements CRUDService<Long, Hospital> {

	@Autowired
	HospitalRepository repository;
	
		public void save(Hospital t) {
			repository.save(t);
		
	}

	public List<Hospital> getAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		repository.delete(id);
		
	}

	public Hospital get(Long id) {
		// TODO Auto-generated method stub
		return repository.findOne(id);
	}

	public long count() {
		// TODO Auto-generated method stub
		return repository.count();
	}
	
}

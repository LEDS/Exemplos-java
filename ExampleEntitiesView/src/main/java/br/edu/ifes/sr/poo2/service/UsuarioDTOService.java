package br.edu.ifes.sr.poo2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.poo2.model.view.UsuarioDTO;
import br.edu.ifes.sr.poo2.repository.UsuarioDTORepository;

@Service
public class UsuarioDTOService  {

	@Autowired
	UsuarioDTORepository repository;
	
	public Iterable<UsuarioDTO> findAll()
	{
		return  repository.findAll();
	}
	
	
	

}

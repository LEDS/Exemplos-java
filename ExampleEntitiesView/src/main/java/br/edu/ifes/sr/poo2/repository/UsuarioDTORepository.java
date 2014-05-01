package br.edu.ifes.sr.poo2.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifes.sr.poo2.model.view.UsuarioDTO;


@Repository

public interface UsuarioDTORepository extends PagingAndSortingRepository<UsuarioDTO, Long>{
	
	
}


package br.edu.ifes.sr.poo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.Usuario;


@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail (String email);
	
}

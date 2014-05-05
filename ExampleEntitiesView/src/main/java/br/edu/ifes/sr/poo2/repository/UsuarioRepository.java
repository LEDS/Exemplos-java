package br.edu.ifes.sr.poo2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.model.view.UsuarioCountDTO;
import br.edu.ifes.sr.poo2.model.view.UsuarioDTO;


@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail (String email);
	
	@Query("SELECT new br.edu.ifes.sr.poo2.model.view.UsuarioCountDTO(count(u) ,u.nome) FROM Usuario u group by u.nome")
	List<UsuarioCountDTO> aggregationFunction();
	
	/* Representanto um SQL nativo*/
	@Query("SELECT new br.edu.ifes.sr.poo2.model.view.UsuarioDTO(u.id, u.nome) FROM Usuario u")
	List<UsuarioDTO> sampleQuery();
	
}

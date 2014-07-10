package br.edu.ifes.sr.poo2.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifes.sr.poo2.model.Usuario;


@Repository
@Transactional
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	Usuario findByEmail (String email);
	
	List<Usuario> findByIdadeBetween(int startAge, int endAge);

    List<Usuario> findByDtCadastro(Date dtCadastro);

    @Query("from Usuario where login = :login and senha = :senha")
    Usuario findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha);

    @Query("from Usuario where login = ?3 and senha = ?2 and idade = ?1")
    Usuario findByLoginAndSenhaAndIdade(int idade, String senha, String login);
	
}

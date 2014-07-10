package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.repository.UsuarioRepository;

@Service
public class UsuarioService implements CRUDService<Long, Usuario> {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	private static final Logger logger = Logger.getLogger(UsuarioService.class);
	
	public boolean isUser (String email)
	{
		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) return false;
		else return true;
	}
	
	public void cadastrar (String email, String senha) throws Exception
	{
		
		if (!isUser(email)){
			
			Usuario usuario = new Usuario();
			usuario.setEmail(email);
			usuario.setSenha(senha);
		
			save(usuario);	
		}
		else{
			logger.error("Usuario cadastrado",new Exception("Usuario cadastrado"));
			
		}
	}

	public void save(Usuario t) {
		
		usuarioRepository.save(t);
		logger.info("Usuario Salvo:"+t.toString());
	}

	public List<Usuario> getAll() {
		
		logger.info("Recuperando usuarios");
		return usuarioRepository.findAll();
	}

	public void delete(Long id) {
		
		
		usuarioRepository.delete(id);
		logger.info("Apagando o usuário do ID: "+id);
	}

	public Usuario get(Long id) {
		logger.info("Recuperando o usuário do ID: "+id);
		return usuarioRepository.findOne(id);
	}

	public long count() {
		logger.info("Retornando a quantidade de usuários");
		return usuarioRepository.count();
	}
	
	public Usuario findByEmail(String email)
	{
		logger.info("Recuperando o usuário pelo email: "+email);
		return usuarioRepository.findByEmail(email);
	}
	
	public void update (Usuario usuario)
	{
		usuarioRepository.saveAndFlush(usuario);
	}
	
	
	

}

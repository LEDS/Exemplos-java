package br.edu.ifes.sr.poo2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifes.sr.poo2.model.Usuario;
import br.edu.ifes.sr.poo2.repository.UsuarioRepository;

@Service
public class UsuarioService implements CRUDService<Long, Usuario> {

	@Autowired
	UsuarioRepository usuarioRepository;
	
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
			throw new Exception("Usuario cadastrado");
		}
	}

	public void save(Usuario t) {
		usuarioRepository.save(t);
		
	}

	public List<Usuario> getAll() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		usuarioRepository.delete(id);
		
	}

	public Usuario get(Long id) {
		// TODO Auto-generated method stub
		return usuarioRepository.findOne(id);
	}

	public long count() {
		// TODO Auto-generated method stub
		return usuarioRepository.count();
	}
	
	public Usuario findByEmail(String email)
	{
		return usuarioRepository.findByEmail(email);
	}
	
	
	

}

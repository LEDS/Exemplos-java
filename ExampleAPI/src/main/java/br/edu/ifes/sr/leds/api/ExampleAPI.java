package br.edu.ifes.sr.leds.api;

import br.edu.ifes.sr.leds.api.model.Usuario;

public interface ExampleAPI {
	
	public Long count();
	
	public boolean isWorking();
	
	public int adicionarUsuario(Usuario usuario);
	
	public Usuario getUsuario (int i);
	

}

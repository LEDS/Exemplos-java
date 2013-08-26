package br.edu.ifes.sr.leds.api;

import br.edu.ifes.sr.leds.api.model.Usuario;
import br.edu.ifes.sr.leds.api.util.ClientAPIUtil;

import com.google.gson.Gson;
import com.sun.jersey.api.client.ClientResponse;

public class ExampleAPIImpl implements ExampleAPI{

	
	private String URL = "http://localhost:8080/examplews/rest/usuario";
	
	private Gson gson = new Gson();
	
	private ClientAPIUtil clientAPIUtil = new ClientAPIUtil();
	
	public Long count() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/count");
		
		String resp = response.getEntity(String.class);
		
		Long count = new Long(resp);
		
		return count;
	}

	public boolean isWorking() {
		
		ClientResponse response = clientAPIUtil.get(URL+"/isWorking");
		
		String resp = response.getEntity(String.class);
		
		if (resp.equals("is Working")) return true;
		
		return false;
	}

	public int adicionarUsuario(Usuario usuario) {
		
		String usuarioJson = gson.toJson(usuario);
		
		ClientResponse response = clientAPIUtil.post(URL+"/add",usuarioJson);
		
		String retorno = response.getEntity(String.class);
		
		Integer id = new Integer(retorno.trim());
		
		return id;
	}

	public Usuario getUsuario(int i) {
		
		ClientResponse response = clientAPIUtil.get(URL+"/get/"+i);
		
		String jsonResposta = response.getEntity(String.class);
		
		Usuario usuario = gson.fromJson(jsonResposta, Usuario.class);
		
		return usuario;

	}
	
	

	

}

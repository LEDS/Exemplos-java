package br.edu.ifes.sr.leds.api.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class ClientAPIUtil {
	
	private Client client;
	
	private WebResource webResource;
	
	private String  JSON = "application/json";
	
	
	public ClientAPIUtil(){
		
		client = Client.create();
	}
	
	public ClientResponse get(String URL){
		
		webResource = client.resource(URL);
		
		ClientResponse response = webResource.accept(JSON).get(ClientResponse.class);
		
		verifyError(response);
		
		return response;
		
	}
	
	public ClientResponse post(String URL, String value){
		
		webResource = client.resource(URL);
		
		ClientResponse response = webResource.type(JSON).post(ClientResponse.class, value);
		
		verifyError(response);
		
		return response;
		
	}
	
	public ClientResponse put(String URL, String value){
		
		webResource = client.resource(URL);
		
		ClientResponse response = webResource.type(JSON).put(ClientResponse.class, value);
		
		verifyError(response);
		
		return response;
		
	}
	
	public ClientResponse delete(String URL){
		
		webResource = client.resource(URL);
		
		ClientResponse response = webResource.type(JSON).delete(ClientResponse.class);
		
		verifyError(response);
		
		return response;
		
	}
	
	
	private void verifyError(ClientResponse response)
	{
		if (response.getStatus() != 200) 
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus() + response.getHeaders());
			
	}

}

package br.edu.ifes.sr.poo2.service;

import java.io.Serializable;
import java.util.List;

public interface CRUDService <ID ,T extends Serializable> {

	
	public void save (T t);
	
	public List<T> getAll();
	
	public void delete (ID id);
	
	public T get(ID id);
	
	public long count();
	
}

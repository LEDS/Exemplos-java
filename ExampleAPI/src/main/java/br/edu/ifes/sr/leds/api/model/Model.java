package br.edu.ifes.sr.leds.api.model;

import java.io.Serializable;


public abstract class Model implements Serializable {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Model) {
        	Model o = (Model) obj;
            if (this.id != null && this.id == o.id) {
                return true;
            }
        }
        return false;
    }
}

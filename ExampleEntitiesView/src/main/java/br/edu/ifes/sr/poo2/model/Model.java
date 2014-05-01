package br.edu.ifes.sr.poo2.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

package model;

import java.io.Serializable;

import javax.persistence.Entity;
@Entity
public class Suelo implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	private int extension;

	public Suelo() {
	}

	public Suelo(int extension) {
		this.extension = extension;
	}

	public int getExtension() {
		return extension;
	}

	public void setExtension(int extension) {
		this.extension = extension;
	}

	@Override
	public String toString() {
		return "Suelo [extension=" + extension + "]";
	}
	
	

}

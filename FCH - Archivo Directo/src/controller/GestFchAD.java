package controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

import gestion.Principal;
import model.Persona;

public class GestFchAD {
	private int regSize = 52;
	private RandomAccessFile fch;
	
	/*
	 * 40 nombre (String:20  = 40 UniCode)
	 * 4 edad (int) 
	 * 8 caracteres (altura) (double)
	 */
	
	
	public GestFchAD(String file_name) {
		
		try {
			fch = new RandomAccessFile(file_name, "rw");
		} catch (FileNotFoundException e) {
			System.err.println("Fichero no encontrado");
		}
		
	}

	public void closeFch() {
		try {
			fch.close();
		} catch (IOException e) {
			
			System.err.println("Error cerrando el fichero de datos.");
		}
		
	}

	public void writeReg(int numReg, Persona reg) {
		int pos = getPos(numReg);
		try {
		
		fch.seek(pos);
			
		/*for (int i = 0; i < 20; i++) {
			if(i < reg.getNombre().length()) {
				fch.writeChar(reg.getNombre().charAt(i));
			}
			else {
				fch.writeChar(' ');
			}
			
		}*/
			
			  char c;
			  for(int i = 0; i < 20; i++){
			  c = (i < reg.getNombre().length()) ? reg.getNombre().charAt(i) : ' ';
			  fch.writeChar(c);
			  }
			 
			
			
		fch.writeInt(reg.getEdad());
		fch.writeDouble(reg.getAltura());
			
			
			
		} catch (IOException e) {
			System.err.println("Error accediendo al fichero");
		}
		
	}

	
	private int getPos(int numReg) {
		
		return (numReg-1) * regSize;
	}

	public Persona readReg(int numReg) {
		String nombre = "";
		int edad = 0; 
		double altura = 0.0;
		int pos = getPos(numReg);
		try {
			
			fch.seek(pos);
			
			for (int i = 0;i < 20;i++) {
				nombre += fch.readChar();
				
			}
			edad = fch.readInt();
			altura = fch.readDouble();
			
					
					
					
			
			
		} catch (IOException e) {
			System.err.println("Error leyendo el fichero");
			
		}
		
		
		
		return new Persona(nombre, edad, altura);
	}

	public long totReg() {
		long contador=1;
		try {
			contador =fch.length() / regSize;
		} catch (IOException e) {
			System.err.println("Error");
		}
		
		
		return contador;
	}

	public List<Persona> getContent() {
		
		List<Persona> lista;
		
		lista.add(Principal.class.);
		
		
		return null;
	}

	

	
	
}

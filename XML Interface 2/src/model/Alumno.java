package model;

public class Alumno {
	
	private int Matricula;
	private String Nombre;
	private String Apellidos;
	
	public Alumno(int matricula, String nombre, String apellidos) {
		super();
		Matricula = matricula;
		Nombre = nombre;
		Apellidos = apellidos;
	}
	public int getMatricula() {
		return Matricula;
	}
	public void setMatricula(int matricula) {
		Matricula = matricula;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	@Override
	public String toString() {
		return ("Alumno: "+Nombre+" "+Apellidos+" y matrícula " +Matricula);
	}
	


}

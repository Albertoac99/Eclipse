package model;

public class Jugador {
	
	private int numero;
	private String nombre;
	private String apellidos;
	private String nick;
	private int puntos;
	
	public Jugador(int numero, String nombre, String apellidos, String nick, int puntos) {
		super();
		this.numero = numero;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nick = nick;
		this.puntos = puntos;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	@Override
	public String toString() {
		return "Jugador [numero=" + numero + ", nombre=" + nombre + ", apellidos=" + apellidos + ", nick=" + nick
				+ ", puntos=" + puntos + "]";
	}
	
	

}

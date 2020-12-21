package model;

import java.io.Serializable;

public class Producto implements Serializable{
	
	private String codigo;
	private String nombre;
	private int stockActual;
	private int stockMinimo;
	private int stockMaximo;
	private int opcion;
	private String comentario;
	private int proveedor;
	private boolean fragil;
	private boolean obsoleto;
	private float pvp;
	
	public Producto(String codigo, String nombre, int stockActual, int stockMinimo, int stockMaximo, int opcion,
			String comentario, int proveedor, boolean fragil, boolean obsoleto, float pvp) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.stockActual = stockActual;
		this.stockMinimo = stockMinimo;
		this.stockMaximo = stockMaximo;
		this.opcion = opcion;
		this.comentario = comentario;
		this.proveedor = proveedor;
		this.fragil = fragil;
		this.obsoleto = obsoleto;
		this.pvp = pvp;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getStockActual() {
		return stockActual;
	}

	public void setStockActual(int stockActual) {
		this.stockActual = stockActual;
	}

	public int getStockMinimo() {
		return stockMinimo;
	}

	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}

	public int getStockMaximo() {
		return stockMaximo;
	}

	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getProveedor() {
		return proveedor;
	}

	public void setProveedor(int proveedor) {
		this.proveedor = proveedor;
	}

	public boolean isFragil() {
		return fragil;
	}

	public void setFragil(boolean fragil) {
		this.fragil = fragil;
	}

	public boolean isObsoleto() {
		return obsoleto;
	}

	public void setObsoleto(boolean obsoleto) {
		this.obsoleto = obsoleto;
	}

	public float getPvp() {
		return pvp;
	}

	public void setPvp(float pvp) {
		this.pvp = pvp;
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", stockActual=" + stockActual + ", stockMinimo="
				+ stockMinimo + ", stockMaximo=" + stockMaximo + ", opcion=" + opcion + ", comentario=" + comentario
				+ ", proveedor=" + proveedor + ", fragil=" + fragil + ", obsoleto=" + obsoleto + ", pvp=" + pvp + "]";
	}
	
	
	

}

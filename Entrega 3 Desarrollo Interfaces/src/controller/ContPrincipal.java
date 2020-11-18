package controller;

import java.awt.event.KeyEvent;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import logic.LogPrincipal;
import model.Producto;
import view.Principal;
import view.Error;

public class ContPrincipal {
	
	private static String codigo;
	private static String nombre;
	private static int stockActual;
	private static int stockMinimo;
	private static int stockMaximo;
	private static int opcion;
	private static String comentario;
	private static int proveedor;
	private static boolean fragil;
	private static boolean obsoleto;
	private static float pvp;
	
	public static void borrar() {
		
		if (JOptionPane.showConfirmDialog(null, "Confirmar el borrado del producto" +Principal.textField.getText(), "Confirmar Borrado", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
			
			limpiar();
			
			Principal.productos.remove(Principal.position);
			
			LogPrincipal.writeDataObject(Principal.RUTA, Principal.productos);
			
		}
	}

	public static void abrir() {
		Principal.position=0;
		Principal.productos = LogPrincipal.readDataObject(Principal.RUTA);
		if(Principal.productos.size()!=0) {
			mostrar();
		}
		
		
	}

	public static void guardar() {
		
		if(LogPrincipal.comprobacionStocks()) {
			
		codigo = Principal.textField.getText();
		nombre = Principal.textField_1.getText();
		stockActual = Integer.parseInt(Principal.textField_2.getText());
		stockMinimo = Integer.parseInt(Principal.textField_3.getText());
		stockMaximo = Integer.parseInt(Principal.textField_4.getText());
		opcion = LogPrincipal.opcion();
		comentario = Principal.textArea.getText();
		proveedor = Principal.comboBox.getSelectedIndex();
		fragil = Principal.chckbxNewCheckBox.isSelected();
		obsoleto = Principal.chckbxNewCheckBox_1.isSelected();
		pvp = Float.parseFloat(Principal.textField_5.getText());
		
		if(Principal.position<Principal.productos.size()) {
			Principal.productos.get(Principal.position).setCodigo(codigo);
			Principal.productos.get(Principal.position).setNombre(nombre);
			Principal.productos.get(Principal.position).setStockActual(stockActual);
			Principal.productos.get(Principal.position).setStockMinimo(stockMinimo);
			Principal.productos.get(Principal.position).setStockMaximo(stockMaximo);
			Principal.productos.get(Principal.position).setOpcion(opcion);
			Principal.productos.get(Principal.position).setComentario(comentario);
			Principal.productos.get(Principal.position).setProveedor(proveedor);
			Principal.productos.get(Principal.position).setFragil(fragil);
			Principal.productos.get(Principal.position).setObsoleto(obsoleto);
			Principal.productos.get(Principal.position).setPvp(pvp);
			LogPrincipal.writeDataObject(Principal.RUTA, Principal.productos);
		}
		else {
			Principal.productos.add(new Producto(codigo,nombre,stockActual,stockMinimo,stockMaximo,opcion,comentario,proveedor,fragil,obsoleto,pvp));
			LogPrincipal.writeDataObject(Principal.RUTA, Principal.productos);
		}
		
		}
		else {
			JDialog error = new Error();
			
			error.setVisible(true);
		}
		
		
		
	}

	public static void caracteres(KeyEvent e) {
		
		boolean letra = LogPrincipal.caracteres(e);
		
		if(letra) {
			e.setKeyChar((char) e.VK_DELETE);
		}
		
	}

	public static void nuevo() {
		
		limpiar();
		if(Principal.position<Principal.productos.size()) {
			Principal.position=Principal.productos.size();
		}
		
		
		
	}
	
	public static void limpiar() {
		
		Principal.textField.setText("");
		Principal.textField_1.setText("");
		Principal.textField_2.setText("");
		Principal.textField_3.setText("");
		Principal.textField_4.setText("");
		Principal.buttonGroup.clearSelection();
		Principal.textArea.setText("");
		Principal.comboBox.setSelectedIndex(-1);
		Principal.chckbxNewCheckBox.setSelected(false);
		Principal.chckbxNewCheckBox_1.setSelected(false);
		Principal.textField_5.setText("");
		
	}
	
	public static void mostrar() {
		Principal.textField.setText(Principal.productos.get(Principal.position).getCodigo());
		Principal.textField_1.setText(Principal.productos.get(Principal.position).getNombre());
		Principal.textField_2.setText(""+Principal.productos.get(Principal.position).getStockActual());
		Principal.textField_3.setText(""+Principal.productos.get(Principal.position).getStockMinimo());
		Principal.textField_4.setText(""+Principal.productos.get(Principal.position).getStockMaximo());
		if(LogPrincipal.opcionSelecionada()==1) {
			Principal.rdbtnNewRadioButton.setSelected(true);
		}
		else if(LogPrincipal.opcionSelecionada()==2) {
			Principal.rdbtnNewRadioButton_1.setSelected(true);
		}
		else if(LogPrincipal.opcionSelecionada()==3){
			Principal.rdbtnNewRadioButton_2.setSelected(true);
		}
		Principal.textArea.setText(Principal.productos.get(Principal.position).getComentario());
		Principal.comboBox.setSelectedIndex(Principal.productos.get(Principal.position).getProveedor());
		Principal.chckbxNewCheckBox.setSelected(Principal.productos.get(Principal.position).isFragil());
		Principal.chckbxNewCheckBox_1.setSelected(Principal.productos.get(Principal.position).isObsoleto());
		Principal.textField_5.setText(""+Principal.productos.get(Principal.position).getPvp());
	}

	public static void cambio(int i) {
		
		if(LogPrincipal.comprobacionPosicion(i) && Principal.productos.size()!=0 && Principal.position<=Principal.productos.size()) {
		Principal.position+=i;
		mostrar();
		}
		
			
	}
	
	public static void inicioProducto(int i) {
		
		if(LogPrincipal.comprobacionPosicion(i) && Principal.productos.size()!=0) {
			Principal.position=0;
			mostrar();
		}
		
	}
	
	public static void finalProducto(int i) {
		if(LogPrincipal.comprobacionPosicion(i) && Principal.productos.size()!=0) {
			Principal.position=Principal.productos.size()-1;
			mostrar();
		}
		
	}
	
	
	
	

}

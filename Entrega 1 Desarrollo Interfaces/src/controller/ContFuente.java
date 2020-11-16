package controller;

import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;

import view.Fuente;

public class ContFuente {
	
	public static void CambiarTodo() {
		
		
		
	}
	
	public static void CambiarFuente(JList list) {
		
		Fuente.lblEjemplo.setFont(new Font(list.getSelectedValue().toString(), Fuente.lblEjemplo.getFont().getStyle(), Fuente.lblEjemplo.getFont().getSize()));
		
	}
	
	public static void CambiarTamaño(JComboBox jComboBox) {
		
		Fuente.lblEjemplo.setFont(new Font(Fuente.lblEjemplo.getFont().getFontName(),Fuente.lblEjemplo.getFont().getStyle(),Integer.parseInt(String.valueOf(jComboBox.getSelectedItem()))));
	}
	
	public static void CambiarTipo(JCheckBox jCheckbox) {
		
		Fuente.lblEjemplo.setFont(new Font(Fuente.lblEjemplo.getFont().getFontName(),jCheckbox.getFont().getStyle(),Fuente.lblEjemplo.getFont().getSize()));
		
	}

}

package PruebasJFrame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PruebaFlowLayout {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ventana");
		
		ventana.setBounds(500, 300, 700, 500);
		ventana.setLayout(new FlowLayout());
		
		
		//Boton Aceptar
		JButton btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(100, 150, 80, 40);
		ventana.add(btnAceptar);
		
		//Boton Cancelar
		JButton btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(200, 150, 80, 40);
		ventana.add(btnCancelar);
		
		//Boton Info
		JButton btnInfo = new JButton();
		btnInfo.setText("Info");
		btnInfo.setBounds(300, 150, 80, 40);
		ventana.add(btnInfo);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);

	}

}

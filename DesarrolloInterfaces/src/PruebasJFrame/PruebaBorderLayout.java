package PruebasJFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PruebaBorderLayout {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Ventana");
		
		ventana.setBounds(500, 300, 700, 500);
		ventana.setLayout(new BorderLayout());
		
		
		//Boton Aceptar
		JButton btnAceptar = new JButton();
		btnAceptar.setText("Aceptar");
		btnAceptar.setBounds(100, 150, 80, 40);
		ventana.add(btnAceptar, BorderLayout.NORTH);
		
		//Boton Cancelar
		JButton btnCancelar = new JButton();
		btnCancelar.setText("Cancelar");
		btnCancelar.setBounds(200, 150, 80, 40);
		ventana.add(btnCancelar, BorderLayout.WEST);
		
		//Boton Info
		JButton btnInfo = new JButton();
		btnInfo.setText("Info");
		btnInfo.setBounds(300, 150, 80, 40);
		ventana.add(btnInfo, BorderLayout.CENTER);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);

	}

}

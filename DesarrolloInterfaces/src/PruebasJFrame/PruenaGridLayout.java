package PruebasJFrame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class PruenaGridLayout {

	public static void main(String[] args) {
JFrame ventana = new JFrame("Ventana");
		
		ventana.setBounds(500, 300, 800, 700);
		ventana.setLayout(new GridLayout(2, 3, 80, 40));
		
		
		//Boton Aceptar
		JButton btnAceptar = new JButton("Aceptar");
		ventana.add(btnAceptar);
				
		//Boton Cancelar
		JButton btnCancelar = new JButton("Cancelar");
		ventana.add(btnCancelar);
				
		//Boton Info
		JButton btnInfo = new JButton("Info");
		ventana.add(btnInfo);
		
		//Boton 10
		JButton btn10 = new JButton();
		btn10.setText("10");
		ventana.add(btn10);
				
		//Boton 11
		JButton btn11 = new JButton();
		btn11.setText("11");
		ventana.add(btn11);
				
		//Boton 12
		JButton btn12 = new JButton();
		btn12.setText("12");
		ventana.add(btn12);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setVisible(true);

	}

}

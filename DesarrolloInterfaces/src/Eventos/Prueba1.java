package Eventos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Prueba1 {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame ("Mi ventana");
		ventana.setBounds(0, 0, 640, 480);
		
		ventana.setLayout(null);
		
		
		JLabel lblMensaje = new JLabel("Hola");
		lblMensaje.setBounds(100, 50, 120, 40);
		ventana.add(lblMensaje);
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(100, 100, 120, 40);
		ventana.add(btnAceptar);
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				press_botonaceptar(lblMensaje);
			}
		});
		
		ventana.addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.out.println("Cerrando aplicación.");
				System.exit(0);
			}
			
			public void windowIconified(WindowEvent e) {
				System.out.println("Ventana minimizada");
			}
			
			public void windowOpened(WindowEvent e) {
				System.out.println("Ventana abierta");
			}
			
			public void windowActivated(WindowEvent e) {
				System.out.println("Ventana activada");
			}
			
			public void windowDeactivated(WindowEvent e) {
				System.out.println("Ventana desactivada");
			}
			
			
		});
		
		
		
		
		
		
		
		
		ventana.setVisible(true);
		
		
		
		
	
	}

	private static void press_botonaceptar(JLabel lblMensaje) {
		lblMensaje.setText("Adios");
		System.out.println("Has pulsado el botón");
	}

}

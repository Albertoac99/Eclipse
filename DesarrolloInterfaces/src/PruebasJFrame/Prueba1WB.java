package PruebasJFrame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextArea;

public class Prueba1WB extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnNewButton;
	private JPanel panel_1;
	private JTextField txtUsuario;
	private JTextField txtContrasea;
	private JTextArea textArea;
	private JTextArea textArea_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Prueba1WB frame = new Prueba1WB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Prueba1WB() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		txtUsuario = new JTextField();
		txtUsuario.setText("Usuario:");
		panel_1.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		textArea = new JTextArea();
		panel_1.add(textArea);
		
		txtContrasea = new JTextField();
		txtContrasea.setText("Contrase\u00F1a:");
		panel_1.add(txtContrasea);
		txtContrasea.setColumns(10);
		
		textArea_1 = new JTextArea();
		panel_1.add(textArea_1);
		
		btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
	}

}

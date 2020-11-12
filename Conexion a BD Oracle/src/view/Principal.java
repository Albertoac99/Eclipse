package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.MatteBorder;

import utils.ConexionDB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Conexi\u00F3n a BD - Oracle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblHost = new JLabel("Host:");
		lblHost.setBounds(34, 22, 46, 14);
		panel.add(lblHost);
		
		JLabel lblPuerto = new JLabel("Puerto:");
		lblPuerto.setBounds(34, 61, 46, 14);
		panel.add(lblPuerto);
		
		JLabel lblBaseDatos = new JLabel("Base Datos:");
		lblBaseDatos.setBounds(34, 108, 72, 14);
		panel.add(lblBaseDatos);
		
		textField = new JTextField();
		textField.setBounds(168, 19, 136, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 58, 55, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(168, 105, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(28, 14, 69, 14);
		panel_2.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(28, 42, 69, 14);
		panel_2.add(lblContrasea);
		
		textField_3 = new JTextField();
		textField_3.setBounds(168, 11, 86, 20);
		panel_2.add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(168, 39, 86, 20);
		panel_2.add(passwordField);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(40, 43, 46, 14);
		panel_3.add(label);
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(ConexionDB.checkConnectionDatabase()) {
					
					label.setText("CORRECTO");
					
					
				}
				else {
					label.setText("ERROR");
				}
				
			}
		});
		btnTest.setBounds(214, 34, 89, 23);
		panel_3.add(btnTest);
	}
}

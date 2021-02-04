package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class Logueo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logueo frame = new Logueo();
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
	public Logueo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(162,248,106));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(162,248,106));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(87, 35, 55, 14);
		panel.add(lblUsuario);
		
		textField = new JTextField();
		textField.setBounds(186, 32, 86, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(87, 83, 89, 14);
		panel.add(lblContraseña);
		
		textField_1 = new JTextField();
		textField_1.setBounds(186, 80, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.setBounds(119, 126, 116, 23);
		panel.add(btnIniciarSesion);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(162,248,106));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblFeriapp = new JLabel("FERIAPP");
		lblFeriapp.setForeground(new Color(255,78,34));
		lblFeriapp.setFont(new Font("Curlz MT", Font.BOLD, 24));
		panel_1.add(lblFeriapp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(162,248,106));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JLabel lblnoTienesCuenta = new JLabel("\u00BFNo tienes cuenta? ");
		lblnoTienesCuenta.setForeground(Color.blue);
		panel_2.add(lblnoTienesCuenta);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		panel_2.add(btnCrearCuenta);
	}
}

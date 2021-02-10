package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;
import javax.swing.border.TitledBorder;

import controller.ContLogueo;

import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Logueo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtUsuario;
	public static JPasswordField txtContrasenia;

	
	public Logueo() {
		
		logueo();
		
	}
	
	public void logueo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 366, 351);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199,238,174));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199,238,174));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(131, 20, 55, 14);
		panel.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(131, 45, 86, 20);
		panel.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		JLabel lblContraseña = new JLabel("Contrase\u00F1a:");
		lblContraseña.setBounds(131, 87, 89, 14);
		panel.add(lblContraseña);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesi\u00F3n");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ContLogueo.iniciarSesion()) {
					dispose();
					ListaCasetas listaCasetas = new ListaCasetas();
					listaCasetas.setVisible(true);
				}
				else {
					ContLogueo.errorSesion();
				}
			}
		});
		btnIniciarSesion.setBounds(118, 160, 116, 23);
		panel.add(btnIniciarSesion);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(131, 123, 86, 20);
		panel.add(txtContrasenia);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(199,238,174));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblFeriapp = new JLabel("FERIAPP");
		lblFeriapp.setForeground(new Color(255,78,34));
		lblFeriapp.setFont(new Font("Curlz MT", Font.BOLD, 24));
		panel_1.add(lblFeriapp);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(Color.BLACK);
		panel_2.setBorder(new TitledBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(153, 180, 209)), "\u00BFEres nuevo en Feriapp?", TitledBorder.CENTER, TitledBorder.TOP, null, Color.DARK_GRAY));
		panel_2.setBackground(new Color(199,238,174));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnCrearCuenta = new JButton("Crear Cuenta");
		btnCrearCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearUsuario crearUsuario = new CrearUsuario();
				crearUsuario.setVisible(true);
			}
		});
		panel_2.add(btnCrearCuenta);
	}
}

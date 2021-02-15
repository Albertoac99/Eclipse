package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContCrearUsuario;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Toolkit;

public class CrearUsuario extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtNuevoUsuario;
	public static JPasswordField txtContrasenia;
	public static JCheckBox cbxDueño;

	
	public CrearUsuario() {
		setTitle("Crear Usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icono.png"));
		
		crearUsuario();
		
	}
	
	public void crearUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 410, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(199,238,174));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRelleneLosSiguientes = new JLabel("Rellene los siguientes campos:");
		lblRelleneLosSiguientes.setBounds(113, 26, 186, 14);
		contentPane.add(lblRelleneLosSiguientes);
		
		JLabel lblNuevoUsuario = new JLabel("Usuario:");
		lblNuevoUsuario.setBounds(113, 72, 78, 14);
		contentPane.add(lblNuevoUsuario);
		
		txtNuevoUsuario = new JTextField();
		txtNuevoUsuario.setBounds(201, 69, 86, 20);
		contentPane.add(txtNuevoUsuario);
		txtNuevoUsuario.setColumns(10);
		
		JLabel lblNuevaContraseña = new JLabel("Contrase\u00F1a:");
		lblNuevaContraseña.setBounds(113, 120, 78, 14);
		contentPane.add(lblNuevaContraseña);
		
		cbxDueño = new JCheckBox("\u00BFDue\u00F1o de caseta?");
		cbxDueño.setBackground(new Color(199,238,174));
		cbxDueño.setBounds(135, 162, 150, 23);
		contentPane.add(cbxDueño);
		
		JButton btnNewButton = new JButton("Crear Usuario");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ContCrearUsuario.crearUsuario()) {
					dispose();
				}
				else {
					ContCrearUsuario.errorCrear();
				}
				
				
			}
		});
		btnNewButton.setBounds(135, 200, 126, 23);
		contentPane.add(btnNewButton);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(201, 117, 86, 20);
		contentPane.add(txtContrasenia);
	}
}

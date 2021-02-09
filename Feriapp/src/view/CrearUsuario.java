package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class CrearUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNuevoUsuario;
	private JTextField txtNuevaContrase�a;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearUsuario frame = new CrearUsuario();
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
	public CrearUsuario() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		JLabel lblNuevaContrase�a = new JLabel("Contrase\u00F1a:");
		lblNuevaContrase�a.setBounds(113, 120, 78, 14);
		contentPane.add(lblNuevaContrase�a);
		
		txtNuevaContrase�a = new JTextField();
		txtNuevaContrase�a.setBounds(201, 117, 86, 20);
		contentPane.add(txtNuevaContrase�a);
		txtNuevaContrase�a.setColumns(10);
		
		JCheckBox cbxDue�o = new JCheckBox("\u00BFDue\u00F1o de caseta?");
		cbxDue�o.setBackground(new Color(199,238,174));
		cbxDue�o.setBounds(135, 162, 150, 23);
		contentPane.add(cbxDue�o);
		
		JButton btnNewButton = new JButton("Crear Usuario");
		btnNewButton.setBounds(135, 200, 126, 23);
		contentPane.add(btnNewButton);
	}
}

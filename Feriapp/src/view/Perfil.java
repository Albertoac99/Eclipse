package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class Perfil extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField txtNuevaContraseña;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Perfil frame = new Perfil();
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
	public Perfil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 296, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(76, 11, 114, 113);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setToolTipText("Usuario");
		textField.setBounds(90, 193, 89, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Cambiar Foto");
		btnNewButton.setBounds(76, 149, 114, 23);
		panel.add(btnNewButton);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.setBounds(69, 292, 133, 23);
		panel.add(btnGuardarCambios);
		
		txtNuevaContraseña = new JPasswordField();
		txtNuevaContraseña.setBounds(90, 243, 89, 20);
		panel.add(txtNuevaContraseña);
	}
}

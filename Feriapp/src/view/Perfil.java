package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContLogueo;
import controller.ContPerfil;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Perfil extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtNuevoUsuario;
	public static JPasswordField txtNuevaContraseña;
	public static JLabel lblFotoPerfil;

	public Perfil() {
		perfil();
		ContPerfil.download();
		txtNuevoUsuario.setText(ContLogueo.lstCuentas.get(0).getUsuario());
		txtNuevaContraseña.setText(ContLogueo.lstCuentas.get(0).getContrasenia());
		
	}
	
	public void perfil() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 296, 410);
		setModal(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblFotoPerfil = new JLabel("");
		lblFotoPerfil.setBounds(76, 11, 114, 113);
		panel.add(lblFotoPerfil);
		
		txtNuevoUsuario = new JTextField();
		txtNuevoUsuario.setToolTipText("Usuario");
		txtNuevoUsuario.setBounds(90, 193, 89, 20);
		panel.add(txtNuevoUsuario);
		txtNuevoUsuario.setColumns(10);
		
		JButton btnCambiarFoto = new JButton("Cambiar Foto");
		btnCambiarFoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContPerfil.seleccionarFichero();
				ContPerfil.upload();
			}
		});
		btnCambiarFoto.setBounds(76, 149, 114, 23);
		panel.add(btnCambiarFoto);
		
		JButton btnGuardarCambios = new JButton("Guardar Cambios");
		btnGuardarCambios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContPerfil.guardarCambios();
			}
		});
		btnGuardarCambios.setBounds(69, 292, 133, 23);
		panel.add(btnGuardarCambios);
		
		txtNuevaContraseña = new JPasswordField();
		txtNuevaContraseña.setBounds(90, 243, 89, 20);
		panel.add(txtNuevaContraseña);
	}
}

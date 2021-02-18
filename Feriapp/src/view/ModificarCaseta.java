package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ContCrearCaseta;
import controller.ContModificarCaseta;

public class ModificarCaseta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtNombreCaseta;
	public static JTextField txtNumeroCaseta;
	public static JTextField txtAforoActual;
	public static JTextField txtAforoMaximo;
	public static JTextField txtHoraApertura;
	public static JCheckBox chckbxCasetaPrivada;
	private Font font = new Font("Comic Sans MS", Font.PLAIN, 11);
	public static JTextField txtNombreCalle;
	
	public ModificarCaseta() {
		modificarCaseta();
		ContModificarCaseta.insertarDatos();
	}
	
	public void modificarCaseta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 327);
		setModal(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(199,238,174));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(199,238,174));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnActualizarCaseta = new JButton("Actualizar Caseta");
		btnActualizarCaseta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ContModificarCaseta.actualizarCaseta()) {
				dispose();
				ContModificarCaseta.casetaActualizada();
				}
			}
		});
		panel_2.add(btnActualizarCaseta);
		
		JButton btnBorrarCaseta = new JButton("Borrar Caseta");
		btnBorrarCaseta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ContModificarCaseta.borrarCaseta()) {
					dispose();
				}
			}
		});
		panel_2.add(btnBorrarCaseta);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199,238,174));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNmeroDeCaseta = new JLabel("N\u00FAmero de caseta:");
		lblNmeroDeCaseta.setBounds(25, 60, 107, 14);
		lblNmeroDeCaseta.setFont(font);
		panel.add(lblNmeroDeCaseta);
		
		JLabel lblNombreCaseta = new JLabel("Nombre Caseta:");
		lblNombreCaseta.setBounds(131, 14, 107, 14);
		lblNombreCaseta.setFont(font);
		panel.add(lblNombreCaseta);
		
		txtNombreCaseta = new JTextField();
		txtNombreCaseta.setEditable(false);
		txtNombreCaseta.setEnabled(false);
		txtNombreCaseta.setBounds(248, 11, 153, 20);
		panel.add(txtNombreCaseta);
		txtNombreCaseta.setColumns(10);
		
		txtNumeroCaseta = new JTextField();
		txtNumeroCaseta.setEnabled(false);
		txtNumeroCaseta.setEditable(false);
		txtNumeroCaseta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ContCrearCaseta.caracteres(e);
			}
		});
		txtNumeroCaseta.setBounds(142, 57, 86, 20);
		panel.add(txtNumeroCaseta);
		txtNumeroCaseta.setColumns(10);
		
		JLabel lblNombreCalle = new JLabel("Nombre calle:");
		lblNombreCalle.setBounds(25, 98, 107, 14);
		lblNombreCalle.setFont(font);
		panel.add(lblNombreCalle);
		
		JLabel lblAforoActual = new JLabel("Aforo Actual:");
		lblAforoActual.setFont(font);
		lblAforoActual.setBounds(287, 60, 94, 14);
		panel.add(lblAforoActual);
		
		JLabel lblAforoMximo = new JLabel("Aforo M\u00E1ximo:");
		lblAforoMximo.setBounds(287, 98, 94, 14);
		lblAforoMximo.setFont(font);
		panel.add(lblAforoMximo);
		
		txtAforoActual = new JTextField();
		txtAforoActual.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ContCrearCaseta.caracteres(e);
			}
		});
		txtAforoActual.setBounds(426, 57, 86, 20);
		panel.add(txtAforoActual);
		txtAforoActual.setColumns(10);
		
		txtAforoMaximo = new JTextField();
		txtAforoMaximo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				ContCrearCaseta.caracteres(e);
			}
		});
		txtAforoMaximo.setBounds(426, 95, 86, 20);
		panel.add(txtAforoMaximo);
		txtAforoMaximo.setColumns(10);
		
		JLabel lblHoraApertura = new JLabel("Hora:");
		lblHoraApertura.setBounds(287, 168, 94, 14);
		lblHoraApertura.setFont(font);
		panel.add(lblHoraApertura);
		
		txtHoraApertura = new JTextField();
		txtHoraApertura.setBounds(426, 166, 86, 20);
		panel.add(txtHoraApertura);
		txtHoraApertura.setColumns(10);
		
		chckbxCasetaPrivada = new JCheckBox("Caseta Privada");
		chckbxCasetaPrivada.setFont(font);
		chckbxCasetaPrivada.setBackground(new Color(199,238,174));
		chckbxCasetaPrivada.setBounds(59, 164, 132, 23);
		panel.add(chckbxCasetaPrivada);
		
		txtNombreCalle = new JTextField();
		txtNombreCalle.setEnabled(false);
		txtNombreCalle.setEditable(false);
		txtNombreCalle.setBounds(142, 96, 86, 20);
		panel.add(txtNombreCalle);
		txtNombreCalle.setColumns(10);
	}
}

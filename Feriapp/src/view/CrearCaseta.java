package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.border.MatteBorder;

import controller.ContCrearCaseta;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class CrearCaseta extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTextField txtNombreCaseta;
	public static JTextField txtNumeroCaseta;
	public static JTextField txtAforoActual;
	public static JTextField txtAforoMaximo;
	public static JTextField txtHoraApertura;
	public static JTextField txtHoraCierre;
	public static JComboBox comboBox;
	public static JCheckBox chckbxCasetaPrivada;
	private Font font = new Font("Comic Sans MS", Font.PLAIN, 11);
	
	
	public CrearCaseta() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icono.png"));
		setTitle("Crear Caseta");
		
		crearCaseta();
		ContCrearCaseta.mostrarCalles();
		
	}

	public void crearCaseta() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 561, 327);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(199,238,174));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(199,238,174));
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) SystemColor.activeCaption));
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		JLabel lblRelleneLosSiguientes = new JLabel("Rellene los siguientes campos para registrar una nueva caseta:");
		lblRelleneLosSiguientes.setFont(font);
		panel_1.add(lblRelleneLosSiguientes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(199,238,174));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnCrearCaseta = new JButton("Crear Caseta");
		btnCrearCaseta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ContCrearCaseta.crearCaseta()) {
					dispose();
				}
			}
		});
		panel_2.add(btnCrearCaseta);
		
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
		txtNombreCaseta.setBounds(248, 11, 153, 20);
		panel.add(txtNombreCaseta);
		txtNombreCaseta.setColumns(10);
		
		txtNumeroCaseta = new JTextField();
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
		
		comboBox = new JComboBox();
		comboBox.setBounds(143, 94, 86, 22);
		panel.add(comboBox);
		
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
		
		JLabel lblHoraApertura = new JLabel("Hora apertura:");
		lblHoraApertura.setBounds(287, 153, 94, 14);
		lblHoraApertura.setFont(font);
		panel.add(lblHoraApertura);
		
		JLabel lblHoraCierrehhmm = new JLabel("Hora cierre:");
		lblHoraCierrehhmm.setBounds(287, 189, 94, 14);
		lblHoraCierrehhmm.setFont(font);
		panel.add(lblHoraCierrehhmm);
		
		txtHoraApertura = new JTextField();
		txtHoraApertura.setBounds(426, 150, 86, 20);
		panel.add(txtHoraApertura);
		txtHoraApertura.setColumns(10);
		
		txtHoraCierre = new JTextField();
		txtHoraCierre.setBounds(426, 186, 86, 20);
		panel.add(txtHoraCierre);
		txtHoraCierre.setColumns(10);
		
		chckbxCasetaPrivada = new JCheckBox("Caseta Privada");
		chckbxCasetaPrivada.setFont(font);
		chckbxCasetaPrivada.setBackground(new Color(199,238,174));
		chckbxCasetaPrivada.setBounds(59, 164, 132, 23);
		panel.add(chckbxCasetaPrivada);
	}
}

package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class CrearCaseta extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearCaseta frame = new CrearCaseta();
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
	public CrearCaseta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		panel_1.add(lblRelleneLosSiguientes);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(199,238,174));
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		JButton btnCrearCaseta = new JButton("Crear Caseta");
		panel_2.add(btnCrearCaseta);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199,238,174));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNmeroDeCaseta = new JLabel("N\u00FAmero de caseta:");
		lblNmeroDeCaseta.setBounds(25, 60, 107, 14);
		panel.add(lblNmeroDeCaseta);
		
		JLabel lblNombreCaseta = new JLabel("Nombre Caseta:");
		lblNombreCaseta.setBounds(131, 14, 107, 14);
		panel.add(lblNombreCaseta);
		
		textField = new JTextField();
		textField.setBounds(248, 11, 153, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 57, 86, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNombreCalle = new JLabel("Nombre calle:");
		lblNombreCalle.setBounds(25, 98, 107, 14);
		panel.add(lblNombreCalle);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(143, 94, 86, 22);
		panel.add(comboBox);
		
		JLabel lblAforoActual = new JLabel("Aforo Actual:");
		lblAforoActual.setBounds(287, 60, 94, 14);
		panel.add(lblAforoActual);
		
		JLabel lblAforoMximo = new JLabel("Aforo M\u00E1ximo:");
		lblAforoMximo.setBounds(287, 98, 94, 14);
		panel.add(lblAforoMximo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(426, 57, 86, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(426, 95, 86, 20);
		panel.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblHoraApertura = new JLabel("Hora apertura:");
		lblHoraApertura.setBounds(287, 153, 94, 14);
		panel.add(lblHoraApertura);
		
		JLabel lblHoraCierrehhmm = new JLabel("Hora cierre:");
		lblHoraCierrehhmm.setBounds(287, 189, 94, 14);
		panel.add(lblHoraCierrehhmm);
		
		textField_4 = new JTextField();
		textField_4.setBounds(426, 150, 86, 20);
		panel.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(426, 186, 86, 20);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JCheckBox chckbxCasetaPrivada = new JCheckBox("Caseta Privada");
		chckbxCasetaPrivada.setBackground(new Color(199,238,174));
		chckbxCasetaPrivada.setBounds(59, 164, 132, 23);
		panel.add(chckbxCasetaPrivada);
	}
}

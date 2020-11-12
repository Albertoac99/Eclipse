package Actividades;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import java.awt.SystemColor;

public class Actividad1 extends JFrame {

	private JPanel contentPane;
	private JPanel panel_6;
	private JPanel panel_7;
	private JRadioButton rdbtnMayorDeEdad;
	private JRadioButton rdbtnMenorDeEdad;
	private JPanel panel_9;
	private JLabel lblSeleccioneMes;
	private JComboBox comboBox;
	private JPanel panel_8;
	private JButton btnInfo;
	private JPanel panel_2;
	private JLabel lblPoblacin;
	private JTextField textField;
	private JLabel lblHombres;
	private JTextField textField_1;
	private JLabel lblMujeres;
	private JTextField textField_2;
	private JPanel panel_3;
	private JLabel lblDatosInciencia;
	private JPanel panel;
	private JList list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Actividad1 frame = new Actividad1();
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
	public Actividad1() {
		setTitle("Info COVID-19");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Medac\\Documents\\Desarrollo de interfaces\\27873737.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 0));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 50));
		
		lblPoblacin = new JLabel("Poblaci\u00F3n: ");
		panel_2.add(lblPoblacin);
		
		textField = new JTextField();
		panel_2.add(textField);
		textField.setColumns(30);
		
		lblHombres = new JLabel("Hombres: ");
		panel_2.add(lblHombres);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(30);
		
		lblMujeres = new JLabel("Mujeres: ");
		panel_2.add(lblMujeres);
		
		textField_2 = new JTextField();
		panel_2.add(textField_2);
		textField_2.setColumns(30);
		
		panel_6 = new JPanel();
		panel_2.add(panel_6);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_7 = new JPanel();
		panel_6.add(panel_7);
		panel_7.setLayout(new GridLayout(3, 0, 0, 0));
		
		rdbtnMayorDeEdad = new JRadioButton("Mayor de edad");
		panel_7.add(rdbtnMayorDeEdad);
		
		rdbtnMenorDeEdad = new JRadioButton("Menor de edad");
		panel_7.add(rdbtnMenorDeEdad);
		
		ButtonGroup grupo1 = new ButtonGroup();
		grupo1.add(rdbtnMayorDeEdad);
		grupo1.add(rdbtnMenorDeEdad);
		
		panel_9 = new JPanel();
		panel_7.add(panel_9);
		panel_9.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblSeleccioneMes = new JLabel("Seleccione mes:");
		panel_9.add(lblSeleccioneMes);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		panel_9.add(comboBox);
		
		panel_8 = new JPanel();
		panel_6.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		btnInfo = new JButton("Info");
		panel_8.add(btnInfo, BorderLayout.CENTER);
		
		panel_3 = new JPanel();
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblDatosInciencia = new JLabel("DATOS INCIENCIA 2020");
		panel_3.add(lblDatosInciencia);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.WEST);
		
		list = new JList();
		list.setBackground(SystemColor.control);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Sevilla", "Huelva", "C\u00E1diz", "C\u00F3rdoba", "M\u00E1laga", "Granada", "Jaen"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel.add(list);
	}

}

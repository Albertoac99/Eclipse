package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.GestFchXML;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Principal extends JFrame {
	final static String FILE_NAME = "archivos\\datos.xml";
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
					Principal frame = new Principal();
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
	public Principal() {
		GestFchXML fch = new GestFchXML(FILE_NAME);
		ArrayList<String> Nombres = new ArrayList<String>();
		ArrayList<String> Apellidos = new ArrayList<String>();
		ArrayList<Integer> Matriculas = new ArrayList<Integer>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		scrollPane.setViewportView(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_1.add(panel_3);
		
		for(int iContador=0;iContador<fch.getAlumnos().size();iContador++) {
			
			JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblMatricula = new JLabel("Matricula:");
		panel.add(lblMatricula);
		
		JLabel label = new JLabel(""+fch.getAlumnos().get(iContador).getMatricula());
		
		panel.add(label);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel.add(lblNombre);
		
		textField = new JTextField(fch.getAlumnos().get(iContador).getNombre().toString());
		textField.setEditable(false);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		panel.add(lblApellidos);
		
		textField_1 = new JTextField(fch.getAlumnos().get(iContador).getApellidos().toString());
		textField_1.setEditable(false);
		panel.add(textField_1);
		textField_1.setColumns(10);	
			
		}
		
		
		
		
		
		String resultado="";;
		

			for(int i=0;i<fch.getAlumnos().size();i++) {
				resultado+=((fch.getAlumnos().get(i).toString()))+"\n";

			}
	
	}

}

package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import utils.GestFchXML;

import java.awt.GridLayout;


import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Principal extends JFrame {
	final static String FILE_NAME = "archivos\\datos.xml";
	private JPanel contentPane;

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
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		String resultado="";
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);;
		

			for(int i=0;i<fch.getAlumnos().size();i++) {
				resultado+=((fch.getAlumnos().get(i).toString()))+"\n";

			}
			textArea.setText(resultado);
		scrollPane.setViewportView(textArea);
	
	}

}

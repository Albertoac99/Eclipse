package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContPrincipal;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import javax.swing.ScrollPaneConstants;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Principal extends JFrame {

	private JPanel contentPane;
	public static JTextArea textArea;
	public static JTextArea textArea_1;
	public static JLabel lblNewLabel;
	public static Principal frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Principal();
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("archivos\\icono.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Archivo");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Conexi\u00F3n...");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JDialog conexion = new Conexion();
				conexion.setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Consulta");
		mnNewMenu.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Cargar...");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContPrincipal.cargar();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Limpiar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ContPrincipal.limpiar(textArea);
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu_2 = new JMenu("Resultados");
		mnNewMenu.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Guardar");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContPrincipal.guardar();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Limpiar");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				ContPrincipal.limpiar(textArea_1);
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Salir");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContPrincipal.salir();
			}
		});
		mntmNewMenuItem_5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmNewMenuItem_5);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1);
		
		textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		scrollPane_1.setViewportView(textArea_1);
		textArea_1.setBackground(Color.black);
		textArea_1.setForeground(Color.white);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Limpiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContPrincipal.limpiar(textArea);
				ContPrincipal.limpiar(textArea_1);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("EJECUTAR");
		panel_1.add(btnNewButton_1);
		
		lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
	}
}

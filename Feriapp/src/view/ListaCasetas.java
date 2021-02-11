package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContListaCasetas;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListaCasetas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable table  = new JTable();

	public ListaCasetas() {
		
		listaCasetas();
		ContListaCasetas.generarTabla();
		
	}
	
	public void listaCasetas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 973, 431);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmAdministracin = new JMenuItem("Administraci\u00F3n");
		mntmAdministracin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmAdministracin);
		
		JMenu mnFiltrar = new JMenu("Filtrar");
		mnNewMenu.add(mnFiltrar);
		
		JMenuItem mntmCasetasPblicas = new JMenuItem("Casetas P\u00FAblicas");
		mnFiltrar.add(mntmCasetasPblicas);
		
		JMenuItem mntmCasetasPrivadas = new JMenuItem("Casetas Privadas");
		mnFiltrar.add(mntmCasetasPrivadas);
		
		JMenuItem mntmCasetasConAforo = new JMenuItem("Casetas Con Aforo");
		mnFiltrar.add(mntmCasetasConAforo);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmSalirDeLa = new JMenuItem("Salir de la aplicaci\u00F3n");
		mnNewMenu.add(mntmSalirDeLa);
		
		JMenu mnPerfil = new JMenu("Perfil");
		menuBar.add(mnPerfil);
		
		JMenuItem mntmEditarPerfil = new JMenuItem("Editar Perfil");
		mntmEditarPerfil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Perfil perfil = new Perfil();
				perfil.setVisible(true);
				
			}
		});
		mntmEditarPerfil.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnPerfil.add(mntmEditarPerfil);
		
		JSeparator separator = new JSeparator();
		mnPerfil.add(separator);
		
		JMenuItem mntmCerrarSesin = new JMenuItem("Cerrar Sesi\u00F3n");
		mnPerfil.add(mntmCerrarSesin);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(199,238,174));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(199,238,174));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setBackground(new Color(199,238,174));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(199,238,174));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel lblCasetas = new JLabel("Casetas:");
		lblCasetas.setForeground(new Color(255,78,34));
		panel.add(lblCasetas);
	}

}

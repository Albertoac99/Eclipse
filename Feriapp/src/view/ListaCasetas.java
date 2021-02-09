package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JTable;

public class ListaCasetas extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaCasetas frame = new ListaCasetas();
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
	public ListaCasetas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
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
		
		table = new JTable();
		table.setBackground(new Color(199,238,174));
		contentPane.add(table, BorderLayout.CENTER);
	}

}

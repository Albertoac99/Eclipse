package view;

import java.awt.BorderLayout;
import java.awt.Color;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.InputEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ListaCasetas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable table  = new JTable();
	public static JMenuItem mntmAdministracin;

	public ListaCasetas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icono.png"));
		setTitle("Casetas");
		
		listaCasetas();
		ContListaCasetas.generarTabla("https://arandacastroalberto.000webhostapp.com/php/getCasetas.php");
		ContListaCasetas.permisos();
	}
	
	public void listaCasetas() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				if(ContListaCasetas.salir()) {
					System.exit(0);
				}
				else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 973, 431);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Opciones");
		menuBar.add(mnNewMenu);
		
		mntmAdministracin = new JMenuItem("Administraci\u00F3n");
		mntmAdministracin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminCasetas adminCasetas = new AdminCasetas();
				adminCasetas.setVisible(true);
			}
		});
		mntmAdministracin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmAdministracin);
		
		JMenu mnFiltrar = new JMenu("Filtrar");
		mnNewMenu.add(mnFiltrar);
		
		JMenuItem mntmCasetasPblicas = new JMenuItem("Casetas P\u00FAblicas");
		mntmCasetasPblicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContListaCasetas.generarTabla("https://arandacastroalberto.000webhostapp.com/php/getCasetaLibre.php?tipoCaseta=0");
			}
		});
		mnFiltrar.add(mntmCasetasPblicas);
		
		JMenuItem mntmCasetasPrivadas = new JMenuItem("Casetas Privadas");
		mntmCasetasPrivadas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContListaCasetas.generarTabla("https://arandacastroalberto.000webhostapp.com/php/getCasetaLibre.php?tipoCaseta=1");
			}
		});
		mnFiltrar.add(mntmCasetasPrivadas);
		
		JMenuItem mntmCasetasConAforo = new JMenuItem("Casetas Con Aforo");
		mntmCasetasConAforo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContListaCasetas.generarTabla("https://arandacastroalberto.000webhostapp.com/php/getCasetasAforo.php");
			}
		});
		mnFiltrar.add(mntmCasetasConAforo);
		
		JMenuItem mntmMostrarTodas = new JMenuItem("Mostrar Todas");
		mntmMostrarTodas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContListaCasetas.generarTabla("https://arandacastroalberto.000webhostapp.com/php/getCasetas.php");
			}
		});
		mnFiltrar.add(mntmMostrarTodas);
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		
		JMenuItem mntmSalirDeLa = new JMenuItem("Salir de la aplicaci\u00F3n");
		mntmSalirDeLa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ContListaCasetas.salir()) {
					System.exit(0);
				}
				else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
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
		mntmCerrarSesin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Logueo logueo = new Logueo();
				logueo.setVisible(true);
				ContListaCasetas.desconexion();
			}
		});
		mnPerfil.add(mntmCerrarSesin);
		
		JMenu mnEstadsticas = new JMenu("Estad\u00EDsticas");
		menuBar.add(mnEstadsticas);
		
		JMenuItem mntmAforo = new JMenuItem("Aforo");
		mntmAforo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadisticasAforo aforo = new EstadisticasAforo();
				aforo.setVisible(true);				
			}
		});
		mnEstadsticas.add(mntmAforo);
		
		JMenuItem mntmPblicaprivada = new JMenuItem("P\u00FAblica/Privada");
		mntmPblicaprivada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EstadisticasPublicaPrivada publicaPrivada = new EstadisticasPublicaPrivada();
				publicaPrivada.setVisible(true);
			}
		});
		mnEstadsticas.add(mntmPblicaprivada);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(199,238,174));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(199,238,174));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setEnabled(false);
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

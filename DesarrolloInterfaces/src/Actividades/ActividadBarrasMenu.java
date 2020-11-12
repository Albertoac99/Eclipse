package Actividades;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JCheckBoxMenuItem;

public class ActividadBarrasMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActividadBarrasMenu frame = new ActividadBarrasMenu();
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
	public ActividadBarrasMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\icon.png"));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setEnabled(false);
		mnArchivo.add(mntmGuardar);
		
		JMenu mnExportar = new JMenu("Exportar");
		mnArchivo.add(mnExportar);
		
		JMenuItem mntmXml = new JMenuItem("XML");
		mnExportar.add(mntmXml);
		
		JMenuItem mntmPdf = new JMenuItem("PDF");
		mnExportar.add(mntmPdf);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mnArchivo.add(mntmSalir);
		
		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);
		
		JMenuItem mntmCopiar = new JMenuItem("Copiar");
		mntmCopiar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnEditar.add(mntmCopiar);
		
		JMenuItem mntmCortar = new JMenuItem("Cortar");
		mntmCortar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.CTRL_MASK));
		mnEditar.add(mntmCortar);
		
		JMenuItem mntmPegar = new JMenuItem("Pegar");
		mntmPegar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnEditar.add(mntmPegar);
		
		JSeparator separator_1 = new JSeparator();
		mnEditar.add(separator_1);
		
		JMenuItem mntmSeleccionarTodo = new JMenuItem("Seleccionar todo");
		mntmSeleccionarTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnEditar.add(mntmSeleccionarTodo);
		
		JCheckBoxMenuItem chckbxmntmMantenerFormato = new JCheckBoxMenuItem("Mantener formato");
		mnEditar.add(chckbxmntmMantenerFormato);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
	}
}

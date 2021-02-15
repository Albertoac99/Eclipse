package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContAdminCasetas;
import controller.ContLogueo;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminCasetas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tblCasetasPropias;

	public AdminCasetas() {
		setTitle("Casetas en propiedad");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icono.png"));
		
		adminCasetas();
		ContAdminCasetas.casetasPropias();
	}
	
	
	public void adminCasetas() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				if(ContAdminCasetas.salir()) {
					System.exit(0);
				}
				else {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				}
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 973, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(199,238,174));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(199,238,174));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.CENTER);
		
		JButton btnCrearCaseta = new JButton("Crear Caseta");
		btnCrearCaseta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearCaseta caseta = new CrearCaseta();
				caseta.setVisible(true);
			}
		});
		panel.add(btnCrearCaseta);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.WEST);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				ListaCasetas casetas = new ListaCasetas();
				casetas.setVisible(true);
			}
		});
		panel_2.add(btnAtras);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(199,238,174));
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tblCasetasPropias = new JTable();
		tblCasetasPropias.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblCasetasPropias.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			ModificarCaseta casetas = new ModificarCaseta();
			casetas.setVisible(true);
				
			}
		});
		tblCasetasPropias.setBackground(new Color(199,238,174));
		scrollPane.setViewportView(tblCasetasPropias);
	}

}

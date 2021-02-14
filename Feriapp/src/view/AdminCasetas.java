package view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContAdminCasetas;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class AdminCasetas extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JTable tblCasetasPropias;

	public AdminCasetas() {
		
		adminCasetas();
		ContAdminCasetas.casetasPropias();
	}
	
	
	public void adminCasetas() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 528, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(199,238,174));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(199,238,174));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JButton btnCrearCaseta = new JButton("Crear Caseta");
		panel_1.add(btnCrearCaseta);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		tblCasetasPropias = new JTable();
		scrollPane.setViewportView(tblCasetasPropias);
	}

}

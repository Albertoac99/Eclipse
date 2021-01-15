package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmPrincipal extends JFrame {

	
	private static final long serialVersionUID = 1L;
	public static JTable tblResult;
	public static JTextArea txtQuery;

	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panelSup = new JPanel();
		contentPane.add(panelSup, BorderLayout.NORTH);
		panelSup.setLayout(new BorderLayout(0, 0));
		
		txtQuery = new JTextArea();
		txtQuery.setRows(3);
		panelSup.add(txtQuery, BorderLayout.CENTER);
		
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.CtrPrincipal.clickEjecutar();
				
			}
		});
		panelSup.add(btnEjecutar, BorderLayout.EAST);
		
		JScrollPane panelDat = new JScrollPane();
		contentPane.add(panelDat, BorderLayout.CENTER);
		
		tblResult = new JTable();
		panelDat.setViewportView(tblResult);
		setVisible(true);
	}

}

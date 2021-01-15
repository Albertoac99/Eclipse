package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrListaCoches;

import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmListaCoches extends JFrame {

	
	private static final long serialVersionUID = 1L;
	public static JTable tblResult;
	
	public FrmListaCoches() {
		createForm();
		CtrListaCoches.loadData();
		setVisible(true);
	} 
	
	
	private void createForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		setTitle("Listado de coches");
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane panelDat = new JScrollPane();
		contentPane.add(panelDat, BorderLayout.CENTER);
		
		tblResult = new JTable();
		tblResult.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblResult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				CtrListaCoches.tableRowSelected();
			}
		});
		panelDat.setViewportView(tblResult);
		setVisible(true);
		
		
		
	}

}

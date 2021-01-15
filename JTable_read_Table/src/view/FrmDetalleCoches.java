package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrDetalleCoche;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDetalleCoches extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	public static JTextField jtxtMarca;
	public static JTextField jtxtModelo;
	public static JTextField jtxtPotencia;

	public FrmDetalleCoches() {

		createFrom();
		setVisible(true);

	}

	private void createFrom() {
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 300, 150);
		setTitle("Editar coche");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 0, 0));

		contentPanel.add(new JLabel("Marca:"));
		jtxtMarca = new JTextField();
		contentPanel.add(jtxtMarca);

		contentPanel.add(new JLabel("Modelo:"));

		jtxtModelo = new JTextField();
		contentPanel.add(jtxtModelo);

		contentPanel.add(new JLabel("Potencia:"));
		jtxtPotencia = new JTextField();
		contentPanel.add(jtxtPotencia);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		JButton okButton = new JButton("GUARDAR");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CtrDetalleCoche.saveData();
				
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);

		JButton cancelButton = new JButton("CANCELAR");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);

	}

}

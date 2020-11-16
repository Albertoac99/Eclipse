package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JTextArea txtrAutorAlbertoAranda = new JTextArea();
			txtrAutorAlbertoAranda.setBackground(SystemColor.control);
			txtrAutorAlbertoAranda.setText("Programa: Editor de Texto\r\n\r\nVersi\u00F3n: 1.0\r\n\r\nFecha: 10/11/2020\r\n\r\nAutor: Alberto Aranda Castro\r\n\r\n");
			contentPanel.add(txtrAutorAlbertoAranda);
		}
	}

}

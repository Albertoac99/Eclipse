package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContAyuda;

import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Toolkit;
import java.awt.SystemColor;

public class Ayuda extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JTextArea textArea;
	/**
	 * Create the dialog.
	 */
	public Ayuda() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes\\boligrafo.png"));
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			textArea = new JTextArea();
			textArea.setBackground(SystemColor.control);
			textArea.setEditable(false);
			ContAyuda.abrir();
			contentPanel.add(textArea);
		}
	}

}

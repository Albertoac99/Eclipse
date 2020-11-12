package Eventos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class ActividadByte extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActividadByte frame = new ActividadByte();
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
	public ActividadByte() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMb = new JLabel("MB");
		lblMb.setBounds(225, 42, 46, 14);
		contentPane.add(lblMb);
		
		JLabel lblBytes = new JLabel("Bytes");
		lblBytes.setBounds(128, 99, 124, 23);
		contentPane.add(lblBytes);
		
		JButton btnConvertir = new JButton("Convertir");
		btnConvertir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conversion(lblBytes);
			}
		});
		btnConvertir.setBounds(129, 153, 89, 23);
		contentPane.add(btnConvertir);
		
		textField = new JTextField();
		textField.setBounds(129, 39, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}

	private void Conversion(JLabel lblBytes) {
		lblBytes.setText(Double.parseDouble(textField.getText()) * 1024 + " bytes");
	}
}

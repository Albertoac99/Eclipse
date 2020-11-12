package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField txf1;
	private JTextField txtf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 272, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNumero1 = new JLabel("Numero1:");
		lblNumero1.setBounds(46, 11, 64, 14);
		panel.add(lblNumero1);
		
		JLabel lblNumero2 = new JLabel("Numero2:");
		lblNumero2.setBounds(46, 36, 64, 14);
		panel.add(lblNumero2);
		
		txf1 = new JTextField();
		txf1.setBounds(120, 8, 86, 20);
		panel.add(txf1);
		txf1.setColumns(10);
		
		txtf2 = new JTextField();
		txtf2.setBounds(120, 33, 86, 20);
		panel.add(txtf2);
		txtf2.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSuma = new JButton("");
		btnSuma.setIcon(new ImageIcon("C:\\Users\\Medac\\Documents\\Desarrollo de interfaces\\suma.png"));
		btnSuma.setBounds(10, 11, 44, 44);
		panel_1.add(btnSuma);
		
		JButton btnResta = new JButton("");
		btnResta.setIcon(new ImageIcon("C:\\Users\\Medac\\Documents\\Desarrollo de interfaces\\restar.png"));
		btnResta.setBounds(74, 11, 44, 44);
		panel_1.add(btnResta);
		
		JButton btnMulti = new JButton("");
		btnMulti.setIcon(new ImageIcon("C:\\Users\\Medac\\Documents\\Desarrollo de interfaces\\multiplicar.png"));
		btnMulti.setBounds(139, 11, 44, 44);
		panel_1.add(btnMulti);
		
		JButton btnDivision = new JButton("");
		btnDivision.setIcon(new ImageIcon("C:\\Users\\Medac\\Documents\\Desarrollo de interfaces\\division.png"));
		btnDivision.setBounds(202, 11, 44, 44);
		panel_1.add(btnDivision);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel lblResultado = new JLabel("");
		panel_2.add(lblResultado);
	}
}

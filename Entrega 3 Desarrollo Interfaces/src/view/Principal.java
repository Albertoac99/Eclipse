package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;

import controller.ContPrincipal;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	public static JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 387);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setVgap(10);
		panel.add(panel_2, BorderLayout.EAST);
		
		JButton btnNewButton_5 = new JButton("Borrar");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ContPrincipal.borrar();
			}
		});
		panel_2.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Guardar");
		panel_2.add(btnNewButton_6);
		
		JButton btnNewButton_4 = new JButton("Nuevo");
		panel_2.add(btnNewButton_4);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.WEST);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 10));
		
		JButton btnNewButton = new JButton("|<");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<<");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton(">>");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton(">|");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		panel_3.add(btnNewButton_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("C\u00F3digo:");
		lblNewLabel.setBounds(24, 26, 46, 14);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(91, 23, 201, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(24, 62, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(91, 59, 201, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Grupo:");
		lblNewLabel_2.setBounds(24, 101, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Pack");
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setBounds(91, 97, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Unidad");
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setBounds(91, 123, 109, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Combinado");
		buttonGroup.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setBounds(91, 149, 109, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(91, 179, 201, 59);
		panel_1.add(textArea);
		
		JLabel lblNewLabel_3 = new JLabel("Comentarios:");
		lblNewLabel_3.setBounds(24, 179, 76, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Otros:");
		lblNewLabel_4.setBounds(24, 256, 46, 14);
		panel_1.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Es fr\u00E1gil");
		chckbxNewCheckBox.setBounds(91, 252, 97, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_5 = new JLabel("Stock Actual:");
		lblNewLabel_5.setBounds(315, 26, 86, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Stock m\u00EDnimo:");
		lblNewLabel_6.setBounds(315, 62, 111, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Stock m\u00E1ximo:");
		lblNewLabel_7.setBounds(315, 101, 109, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Proveedor:");
		lblNewLabel_8.setBounds(315, 184, 68, 14);
		panel_1.add(lblNewLabel_8);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Obsoleto");
		chckbxNewCheckBox_1.setBounds(195, 252, 97, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_9 = new JLabel("PVP:");
		lblNewLabel_9.setBounds(315, 256, 46, 14);
		panel_1.add(lblNewLabel_9);
		
		textField_2 = new JTextField();
		textField_2.setBounds(411, 23, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(411, 59, 86, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(411, 98, 86, 20);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(411, 180, 30, 22);
		panel_1.add(comboBox);
		
		textField_5 = new JTextField();
		textField_5.setBounds(411, 253, 86, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
	}
}

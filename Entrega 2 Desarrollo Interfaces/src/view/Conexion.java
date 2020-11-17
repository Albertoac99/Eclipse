package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Conexion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;


	/**
	 * Create the dialog.
	 */
	public Conexion() {
		setBounds(100, 100, 232, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JRadioButton rdbtnNewRadioButton = new JRadioButton("Oracle");
				panel.add(rdbtnNewRadioButton);
			}
			{
				JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("MySQL");
				panel.add(rdbtnNewRadioButton_1);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Host:");
			lblNewLabel.setBounds(34, 31, 46, 14);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("Port:");
			lblNewLabel_1.setBounds(34, 56, 46, 14);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("SID:");
			lblNewLabel_2.setBounds(34, 81, 46, 14);
			panel.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("User");
			lblNewLabel_3.setBounds(34, 131, 46, 14);
			panel.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("Pass");
			lblNewLabel_4.setBounds(34, 156, 46, 14);
			panel.add(lblNewLabel_4);
			
			textField = new JTextField();
			textField.setBounds(90, 28, 86, 20);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setBounds(90, 53, 86, 20);
			panel.add(textField_1);
			textField_1.setColumns(10);
			
			textField_2 = new JTextField();
			textField_2.setBounds(90, 78, 86, 20);
			panel.add(textField_2);
			textField_2.setColumns(10);
			
			textField_3 = new JTextField();
			textField_3.setBounds(90, 128, 86, 20);
			panel.add(textField_3);
			textField_3.setColumns(10);
			
			textField_4 = new JTextField();
			textField_4.setBounds(90, 153, 86, 20);
			panel.add(textField_4);
			textField_4.setColumns(10);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
			{
				JButton btnNewButton = new JButton("Conectar");
				panel.add(btnNewButton);
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}

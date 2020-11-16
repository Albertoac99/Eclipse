package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContFuente;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fuente extends JDialog {
	public static JLabel lblEjemplo;
	private final JPanel contentPanel = new JPanel();


	/**
	 * Create the dialog.
	 */
	public Fuente() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 3, 0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1, BorderLayout.NORTH);
				{
					JLabel lblFuente = new JLabel("Fuente");
					panel_1.add(lblFuente);
				}
			}
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					JList list = new JList();
					list.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							ContFuente.CambiarFuente(list);
						}
					});
					
					list.setFont(new Font("Tahoma", Font.PLAIN, 11));
					list.setModel(new AbstractListModel() {
						String[] values = new String[] {"Arial", "Courier", "Comics Sans", "Tahoma", "Symbol", "Pristina", "Ravie", "Georgia", "Gigi", "Calibri", "Cambria", "Magneto", "Marlett"};
						public int getSize() {
							return values.length;
						}
						public Object getElementAt(int index) {
							return values[index];
						}
					});
					scrollPane.setViewportView(list);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1, BorderLayout.NORTH);
				{
					JLabel lblEstilo = new JLabel("Estilo");
					panel_1.add(lblEstilo);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				panel_1.setLayout(new GridLayout(4, 0, 0, 0));
				{
					JCheckBox chckbxNormal = new JCheckBox("Normal");
					panel_1.add(chckbxNormal);
				}
				{
					JCheckBox chckbxNegrita = new JCheckBox("Negrita");
					chckbxNegrita.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ContFuente.CambiarTipo(chckbxNegrita);
						}
					});
					panel_1.add(chckbxNegrita);
				}
				{
					JCheckBox chckbxNewCheckBox = new JCheckBox("Cursiva");
					panel_1.add(chckbxNewCheckBox);
				}
				{
					JCheckBox chckbxSubrallado = new JCheckBox("Subrayado");
					panel_1.add(chckbxSubrallado);
				}
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1, BorderLayout.NORTH);
				{
					JLabel lblTamao = new JLabel("Tama\u00F1o");
					panel_1.add(lblTamao);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel.add(panel_1, BorderLayout.CENTER);
				{
					JComboBox comboBox = new JComboBox();
					comboBox.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							ContFuente.CambiarTamaño(comboBox);
						}
					});
					comboBox.setModel(new DefaultComboBoxModel(new String[] {"10", "12", "15", "18", "20", "24"}));
					panel_1.add(comboBox);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel = new JPanel();
				buttonPane.add(panel, BorderLayout.EAST);
				{
					JButton okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							dispose();
						}
					});
					panel.add(okButton);
					okButton.setActionCommand("OK");
					getRootPane().setDefaultButton(okButton);
				}
				{
					JButton cancelButton = new JButton("Cancelar");
					cancelButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					panel.add(cancelButton);
					cancelButton.setActionCommand("Cancel");
				}
			}
			{
				JPanel panel = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel.getLayout();
				flowLayout.setHgap(20);
				buttonPane.add(panel, BorderLayout.WEST);
				{
					lblEjemplo = new JLabel("EJEMPLO");
					panel.add(lblEjemplo);
				}
			}
		}
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

}

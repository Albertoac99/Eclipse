package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ContColores;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Colores extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public static JLabel lblEjemplo;
	

	/**
	 * Create the dialog.
	 */
	public Colores() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("imagenes\\boligrafo.png"));
		setResizable(false);
		setTitle("Colores");
		setBounds(100, 100, 450, 230);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 2, 20, 20));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(20, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setHgap(20);
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1, BorderLayout.NORTH);
				{
					JLabel lblFondo = new JLabel("Fondo");
					panel_1.add(lblFondo);
				}
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel.add(panel_1, BorderLayout.CENTER);
			
			JButton button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFondo(Color.black);
				}
			});
			button.setIcon(new ImageIcon("imagenes\\negro.png"));
			button.setBounds(16, 22, 33, 33);
			panel_1.add(button);
			
			JButton button_1 = new JButton("");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFondo(Color.red);
				}
			});
			button_1.setIcon(new ImageIcon("imagenes\\rojo.png"));
			button_1.setBounds(59, 22, 33, 33);
			panel_1.add(button_1);
			
			JButton button_2 = new JButton("");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFondo(Color.blue);
				}
			});
			button_2.setIcon(new ImageIcon("imagenes\\azul.png"));
			button_2.setBounds(145, 22, 33, 33);
			panel_1.add(button_2);
			
			JButton button_3 = new JButton("");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFondo(Color.green);
				}
			});
			button_3.setIcon(new ImageIcon("imagenes\\verde.png"));
			button_3.setBounds(102, 22, 33, 33);
			panel_1.add(button_3);
			
			JButton button_4 = new JButton("");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFondo(Color.orange);
				}
			});
			button_4.setIcon(new ImageIcon("imagenes\\naranja.png"));
			button_4.setBounds(59, 66, 33, 33);
			panel_1.add(button_4);
			
			JButton button_5 = new JButton("");
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFondo(Color.white);
				}
			});
			button_5.setIcon(new ImageIcon("imagenes\\blanco.png"));
			button_5.setBounds(16, 66, 33, 33);
			panel_1.add(button_5);
			
			JButton button_6 = new JButton("");
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFondo(Color.yellow);
				}
			});
			button_6.setIcon(new ImageIcon("imagenes\\amarillo.png"));
			button_6.setBounds(102, 66, 33, 33);
			panel_1.add(button_6);
			
			JButton button_7 = new JButton("");
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFondo(Color.cyan);
				}
			});
			button_7.setIcon(new ImageIcon("imagenes\\celeste.png"));
			button_7.setBounds(145, 66, 33, 33);
			panel_1.add(button_7);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JPanel panel_1 = new JPanel();
				FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
				flowLayout.setHgap(20);
				flowLayout.setAlignment(FlowLayout.LEFT);
				panel.add(panel_1, BorderLayout.NORTH);
				{
					JLabel lblNewLabel = new JLabel("Fuente");
					panel_1.add(lblNewLabel);
				}
			}
			
			JPanel panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel.add(panel_1, BorderLayout.CENTER);
			
			JButton button = new JButton("");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFuente(Color.black);
				}
			});
			button.setIcon(new ImageIcon("imagenes\\negro.png"));
			button.setBounds(16, 22, 33, 33);
			panel_1.add(button);
			
			JButton button_1 = new JButton("");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFuente(Color.red);
				}
			});
			button_1.setIcon(new ImageIcon("imagenes\\rojo.png"));
			button_1.setBounds(59, 22, 33, 33);
			panel_1.add(button_1);
			
			JButton button_2 = new JButton("");
			button_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFuente(Color.blue);
				}
			});
			button_2.setIcon(new ImageIcon("imagenes\\azul.png"));
			button_2.setBounds(145, 22, 33, 33);
			panel_1.add(button_2);
			
			JButton button_3 = new JButton("");
			button_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFuente(Color.green);
				}
			});
			button_3.setIcon(new ImageIcon("imagenes\\verde.png"));
			button_3.setBounds(102, 22, 33, 33);
			panel_1.add(button_3);
			
			JButton button_4 = new JButton("");
			button_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFuente(Color.orange);
				}
			});
			button_4.setIcon(new ImageIcon("imagenes\\naranja.png"));
			button_4.setBounds(59, 66, 33, 33);
			panel_1.add(button_4);
			
			JButton button_5 = new JButton("");
			button_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFuente(Color.white);
				}
			});
			button_5.setIcon(new ImageIcon("imagenes\\blanco.png"));
			button_5.setBounds(16, 66, 33, 33);
			panel_1.add(button_5);
			
			JButton button_6 = new JButton("");
			button_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFuente(Color.yellow);
				}
			});
			button_6.setIcon(new ImageIcon("imagenes\\amarillo.png"));
			button_6.setBounds(102, 66, 33, 33);
			panel_1.add(button_6);
			
			JButton button_7 = new JButton("");
			button_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ContColores.cambiarColorFuente(Color.cyan);
				}
			});
			button_7.setIcon(new ImageIcon("imagenes\\celeste.png"));
			button_7.setBounds(145, 66, 33, 33);
			panel_1.add(button_7);
		}
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new BorderLayout(0, 0));
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
			{
				JPanel panel = new JPanel();
				buttonPane.add(panel, BorderLayout.EAST);
				{
					JButton okButton = new JButton("OK");
					okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							
							ContColores.CambiarColor();
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
			
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}

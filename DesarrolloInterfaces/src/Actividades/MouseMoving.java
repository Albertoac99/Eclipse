package Actividades;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FileDialog;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MouseMoving extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	public static MouseMoving frame;
	private JButton btnGuardar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new MouseMoving();
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
	public MouseMoving() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnBoton = new JButton("boton");
		btnBoton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JDialog ventanita = new JDialogNueva();
				ventanita.setModal(true);
				ventanita.setVisible(true);
				
				/*
				JDialog ventanita = new JDialog();
				ventanita.setBounds(100, 300, 200, 200);
				ventanita.setModal(true);//Para tener que resolver esta ventana primero
				ventanita.setVisible(true);
				*/
			}
		});
		btnBoton.setBounds(61, 34, 61, 23);
		btnBoton.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				//System.out.println(e.getX()+", "+e.getY());
			}
		});
		contentPane.setLayout(null);
		contentPane.add(btnBoton);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar()=="r".charAt(0)) {
					contentPane.setBackground(Color.red);
				}
				
				else if(e.getKeyChar()=="g".charAt(0)) {
					contentPane.setBackground(Color.green);
				}
				else if(e.getKeyChar()=="b".charAt(0)) {
					contentPane.setBackground(Color.blue);
				}
				//System.out.println("Pulsando " + e.getKeyChar());
			}
			@Override
			public void keyReleased(KeyEvent e) {
				//System.out.println("Soltando");
			}
			@Override
			public void keyTyped(KeyEvent e) {
			if(e.getKeyChar()=="x".charAt(0)) {
					e.setKeyChar((char) e.VK_DELETE);
				}
				//System.out.println("Escribiendo");
			}
		});
		textField.setBounds(164, 35, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnJputo = new JButton("Abrir");
		btnJputo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FileDialog FchAbrir = new FileDialog(frame, "Abrir documento...", FileDialog.LOAD);
				FchAbrir.setVisible(true);
			}
		});
		btnJputo.setBounds(161, 142, 89, 23);
		contentPane.add(btnJputo);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Antes de mostrar");
				FileDialog FchGuardar = new FileDialog(frame, "Abrir documento...", FileDialog.SAVE);
				FchGuardar.setVisible(true);
				System.out.println("Despues de mostrar");
				
				String directorio = FchGuardar.getDirectory();
				String fichero = FchGuardar.getFile();
				System.out.println(directorio);
				System.out.println(fichero);
				
				
				
			}
		});
		btnGuardar.setBounds(273, 142, 89, 23);
		contentPane.add(btnGuardar);
	}
}

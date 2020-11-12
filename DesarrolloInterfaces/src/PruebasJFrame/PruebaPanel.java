package PruebasJFrame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PruebaPanel {
	
	static Font fntTexto = new Font("Arial", Font.BOLD + Font.ITALIC,20);
	
	
	public static void main(String[] args) {
		
		
		JFrame ventana = new JFrame("Usando paneles...");
		ventana.setBounds(600, 300, 1000, 400);
		ventana.setResizable(true);
		ventana.setLayout(new FlowLayout());
		ventana.getContentPane().setBackground(Color.cyan);
		ventana.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Medac\\Desktop\\dibujito.png"));
		
		String [] misColores = {"Rojo", "Verde", "Azul"};
		JComboBox<String> miLista = new JComboBox<String>(misColores);
		
		
		JButton btn1 = new JButton("Acceder");
		btn1.setForeground(Color.red);
		
		JLabel lbl1 = new JLabel("Usuario:");
		lbl1.setForeground(Color.red);//Cambiar el color de las letras
		lbl1.setFont(fntTexto);
		JLabel lbl2 = new JLabel("Contraseña:");
		lbl2.setForeground(Color.red);
		
		JTextField txt1 = new JTextField(10);
		JPasswordField txt2 = new JPasswordField(10);
		
		JCheckBox chkEnviar = new JCheckBox("Desea envío pagado");
		
		JPanel pan2 = new JPanel();
		pan2.setLayout(new FlowLayout());
		pan2.add(chkEnviar);		
		
		JPanel panDatos = new JPanel();
		panDatos.setBackground(Color.CYAN);//Cambiar el color del fondo
		panDatos.setLayout(new GridLayout(2, 2, 5, 5));
		panDatos.add(lbl1);
		panDatos.add(txt1);
		panDatos.add(lbl2);
		panDatos.add(txt2);
		
		JTextArea txtComentarios = new JTextArea(10,30);
		JScrollPane paneScroll = new JScrollPane(txtComentarios, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		JPanel panInf = new JPanel();
		panInf.setBackground(Color.CYAN);
		panInf.setLayout(new FlowLayout());
		panInf.add(panDatos);
		panInf.add(btn1);
		panInf.add(paneScroll);
		panInf.add(miLista);
		panInf.add(pan2);
		
		ventana.add(panInf);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

}

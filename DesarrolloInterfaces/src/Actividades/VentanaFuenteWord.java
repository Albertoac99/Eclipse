package Actividades;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpinnerListModel;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;

public class VentanaFuenteWord extends JFrame {

	private JPanel contentPane;
	private JTextField txtcuerpo;
	private JTextField txtNormal;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaFuenteWord frame = new VentanaFuenteWord();
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
	public VentanaFuenteWord() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4);
		panel_4.setLayout(new GridLayout(2, 3, 0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblColorDeFuente = new JLabel("Color de fuente:");
		panel_5.add(lblColorDeFuente);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblEstiloSubrayado = new JLabel("Estilo subrayado:");
		panel_6.add(lblEstiloSubrayado);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		JLabel lblColorDeSubrayado = new JLabel("Color de subrayado:");
		panel_7.add(lblColorDeSubrayado);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Autom\u00E1tico", "Verde", "Morado", "Rojo", "Negro", "Azul", "Amarillo"}));
		panel_8.add(comboBox);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"(ninguno)", "Solo palabras", "- - - - - - - - - ", "--------------"}));
		panel_9.add(comboBox_1);
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Autom\u00E1tico", "Verde", "Negro", "Rojo", "Azul", "Amarillo"}));
		panel_10.add(comboBox_2);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_15 = new JPanel();
		panel_3.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_15.add(panel_12, BorderLayout.NORTH);
		
		JLabel lblFuente = new JLabel("Fuente:");
		panel_12.add(lblFuente);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBorder(new LineBorder(SystemColor.scrollbar));
		panel_15.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new BorderLayout(0, 0));
		
		JList list = new JList();
		list.setToolTipText("");
		list.setBorder(null);
		list.setBackground(SystemColor.control);
		list.setForeground(SystemColor.desktop);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"+Cuerpo", "+T\u00EDtulos", "Agency FB", "Algerian", "Arial"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_17.add(list, BorderLayout.WEST);
		
		JScrollBar scrollBar = new JScrollBar();
		panel_17.add(scrollBar, BorderLayout.EAST);
		
		txtcuerpo = new JTextField();
		txtcuerpo.setText("+Cuerpo");
		panel_17.add(txtcuerpo, BorderLayout.NORTH);
		txtcuerpo.setColumns(10);
		
		JPanel panel_16 = new JPanel();
		panel_3.add(panel_16);
		panel_16.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_13 = new JPanel();
		panel_16.add(panel_13, BorderLayout.NORTH);
		
		JLabel lblEstiloDeFuente = new JLabel("Estilo de fuente:");
		panel_13.add(lblEstiloDeFuente);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBorder(new LineBorder(SystemColor.scrollbar));
		panel_16.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new BorderLayout(0, 0));
		
		txtNormal = new JTextField();
		txtNormal.setText("Normal");
		panel_18.add(txtNormal, BorderLayout.NORTH);
		txtNormal.setColumns(10);
		
		JList list_1 = new JList();
		list_1.setBackground(SystemColor.control);
		list_1.setModel(new AbstractListModel() {
			String[] values = new String[] {"Normal", "Cursiva", "Negrita", "Negrita Cursiva"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_18.add(list_1, BorderLayout.WEST);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		panel_18.add(scrollBar_1, BorderLayout.EAST);
		
		JPanel panel_11 = new JPanel();
		panel_3.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_11.add(panel_14, BorderLayout.NORTH);
		
		JLabel lblTamao = new JLabel("Tama\u00F1o:");
		panel_14.add(lblTamao);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBorder(new LineBorder(SystemColor.scrollbar));
		panel_11.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new BorderLayout(0, 0));
		
		JList list_2 = new JList();
		list_2.setBackground(SystemColor.control);
		list_2.setModel(new AbstractListModel() {
			String[] values = new String[] {"8", "9", "10", "11", "12"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		panel_19.add(list_2, BorderLayout.WEST);
		
		textField = new JTextField();
		textField.setText("11");
		panel_19.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JScrollBar scrollBar_2 = new JScrollBar();
		panel_19.add(scrollBar_2, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_20 = new JPanel();
		panel_20.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));
		
		JLabel lblEfectos = new JLabel("Efectos");
		panel_20.add(lblEfectos, BorderLayout.NORTH);
		
		JPanel panel_22 = new JPanel();
		panel_20.add(panel_22, BorderLayout.WEST);
		panel_22.setLayout(new GridLayout(4, 1, 0, 0));
		
		JCheckBox chckbxTachado = new JCheckBox("Tachado");
		panel_22.add(chckbxTachado);
		
		JCheckBox chckbxDobleTachado = new JCheckBox("Doble Tachado");
		panel_22.add(chckbxDobleTachado);
		
		JCheckBox chckbxSuperdice = new JCheckBox("Super\u00EDdice");
		panel_22.add(chckbxSuperdice);
		
		JCheckBox chckbxSubndice = new JCheckBox("Sub\u00EDndice");
		panel_22.add(chckbxSubndice);
		
		JPanel panel_23 = new JPanel();
		panel_20.add(panel_23, BorderLayout.EAST);
		panel_23.setLayout(new GridLayout(4, 1, 0, 0));
		
		JCheckBox chckbxVersalitas = new JCheckBox("Versalitas");
		panel_23.add(chckbxVersalitas);
		
		JCheckBox chckbxMaysculas = new JCheckBox("May\u00FAsculas");
		panel_23.add(chckbxMaysculas);
		
		JCheckBox chckbxOculto = new JCheckBox("Oculto");
		panel_23.add(chckbxOculto);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_21);
		panel_21.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_24 = new JPanel();
		panel_21.add(panel_24, BorderLayout.NORTH);
		panel_24.setLayout(new BorderLayout(0, 0));
		
		JLabel lblVistaPrevia = new JLabel("Vista Previa");
		panel_24.add(lblVistaPrevia);
		
		JPanel panel_25 = new JPanel();
		panel_21.add(panel_25, BorderLayout.CENTER);
		panel_25.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_27 = new JPanel();
		panel_27.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_25.add(panel_27);
		
		JLabel lblcuerpo = new JLabel("+Cuerpo");
		panel_27.add(lblcuerpo);
		
		JPanel panel_28 = new JPanel();
		panel_25.add(panel_28);
		
		JTextPane txtpnEstaEsLa = new JTextPane();
		txtpnEstaEsLa.setBackground(SystemColor.control);
		panel_28.add(txtpnEstaEsLa);
		txtpnEstaEsLa.setText("Esta es la fuente del tema del cuerpo. El tema del documento actual define qu\u00E9 fuente se utilizar\u00E1");
		
		JPanel panel_26 = new JPanel();
		panel_21.add(panel_26, BorderLayout.SOUTH);
		
		JButton btnEstablecerComoPredeterminado = new JButton("Establecer como predeterminado");
		btnEstablecerComoPredeterminado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_26.add(btnEstablecerComoPredeterminado);
		
		JButton btnEfectosDeTexto = new JButton("Efectos de texto:");
		btnEfectosDeTexto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_26.add(btnEfectosDeTexto);
		
		JSeparator separator = new JSeparator();
		panel_26.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		panel_26.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		panel_26.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		panel_26.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		panel_26.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		panel_26.add(separator_5);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_26.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_26.add(btnCancelar);
	}

}

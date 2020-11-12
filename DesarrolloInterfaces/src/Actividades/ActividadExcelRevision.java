package Actividades;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import java.awt.Button;
import java.awt.Checkbox;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class ActividadExcelRevision extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ActividadExcelRevision frame = new ActividadExcelRevision();
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
	public ActividadExcelRevision() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 522);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Medac\\Desktop\\abc.JPG"));
		panel.add(label);
		
		JLabel lblCambieElModo = new JLabel("Cambie el modo en el que Excel corrige y aplica el formato a su texto.");
		panel.add(lblCambieElModo);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.EAST);
		
		JButton btnAceptar = new JButton("Aceptar");
		panel_2.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		panel_2.add(btnCancelar);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.NORTH);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.scrollbar);
		panel_5.setBorder(null);
		panel_4.add(panel_5, BorderLayout.NORTH);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JLabel lblOpcionesDeAutocorreccin = new JLabel("  Opciones de Autocorrecci\u00F3n");
		lblOpcionesDeAutocorreccin.setBackground(SystemColor.controlShadow);
		panel_5.add(lblOpcionesDeAutocorreccin);
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_6.add(panel_7, BorderLayout.WEST);
		
		JTextPane txtpnCambieLaForma = new JTextPane();
		txtpnCambieLaForma.setEditable(false);
		txtpnCambieLaForma.setBackground(SystemColor.control);
		txtpnCambieLaForma.setText("Cambie la forma en que Excel corrige y da formato al texto\r\nmientras escribe:");
		panel_7.add(txtpnCambieLaForma);
		
		JPanel panel_8 = new JPanel();
		panel_6.add(panel_8, BorderLayout.EAST);
		
		JButton btnOpcionesDeAutocorreccin = new JButton("Opciones de Autocorrecci\u00F3n...");
		panel_8.add(btnOpcionesDeAutocorreccin);
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.scrollbar);
		panel_9.add(panel_10, BorderLayout.NORTH);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAlCorregirLa = new JLabel("  Al corregir la ortograf\u00EDa en los programas de Microsoft Office");
		panel_10.add(lblAlCorregirLa, BorderLayout.NORTH);
		
		JPanel panel_11 = new JPanel();
		panel_9.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_11.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_12.add(panel_14, BorderLayout.WEST);
		panel_14.setLayout(new GridLayout(6, 1, 0, 0));
		
		JCheckBox chckbxOmitirPalabrasEn = new JCheckBox("Omitir palabras en MAY\u00DASCULAS");
		chckbxOmitirPalabrasEn.setSelected(true);
		panel_14.add(chckbxOmitirPalabrasEn);
		
		JCheckBox chckbxOmitirPalabrasQue = new JCheckBox("Omitir palabras que contengan n\u00FAmeros");
		chckbxOmitirPalabrasQue.setSelected(true);
		panel_14.add(chckbxOmitirPalabrasQue);
		
		JCheckBox chckbxOmitirArchivosY = new JCheckBox("Omitir archivos y direcciones de Internet");
		chckbxOmitirArchivosY.setSelected(true);
		panel_14.add(chckbxOmitirArchivosY);
		
		JCheckBox chckbxMarcarPalabrasRepetidas = new JCheckBox("Marcar palabras repetidas");
		chckbxMarcarPalabrasRepetidas.setSelected(true);
		panel_14.add(chckbxMarcarPalabrasRepetidas);
		
		JCheckBox chckbxExigirMaysculasAcentuadas = new JCheckBox("Exigir may\u00FAsculas acentuadas en franc\u00E9s");
		panel_14.add(chckbxExigirMaysculasAcentuadas);
		
		JCheckBox chckbxSugerirSoloDel = new JCheckBox("Sugerir solo del diccionario principal");
		panel_14.add(chckbxSugerirSoloDel);
		
		JPanel panel_13 = new JPanel();
		panel_11.add(panel_13);
		panel_13.setLayout(new BorderLayout(10, 0));
		
		JPanel panel_15 = new JPanel();
		panel_13.add(panel_15, BorderLayout.NORTH);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_15.add(panel_16, BorderLayout.WEST);
		
		JButton btnDiccionariosPersonalizados = new JButton("Diccionarios personalizados...");
		panel_16.add(btnDiccionariosPersonalizados);
		
		JPanel panel_17 = new JPanel();
		panel_13.add(panel_17, BorderLayout.WEST);
		panel_17.setLayout(new GridLayout(4, 0, 0, 0));
		
		JLabel lblModosDelFrancs = new JLabel("  Modos del franc\u00E9s:");
		panel_17.add(lblModosDelFrancs);
		
		JLabel lblModosDelEspaol = new JLabel("  Modos del espa\u00F1ol:");
		panel_17.add(lblModosDelEspaol);
		
		JLabel lblModosDelPortugus = new JLabel("  Modos del portugu\u00E9s brasile\u00F1o:");
		panel_17.add(lblModosDelPortugus);
		
		JLabel lblIdiomaDelDiccionario = new JLabel("  Idioma del diccionario:");
		panel_17.add(lblIdiomaDelDiccionario);
		
		JPanel panel_18 = new JPanel();
		panel_13.add(panel_18, BorderLayout.CENTER);
		panel_18.setLayout(new BorderLayout(0, 5));
		
		JPanel panel_19 = new JPanel();
		panel_18.add(panel_19, BorderLayout.WEST);
		panel_19.setLayout(new GridLayout(4, 1, 0, 5));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ortograf\u00EDa tradicional y nueva", "Ortograf\u00EDa tradicional", "Nueva ortograf\u00EDa"}));
		panel_19.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Solo formas verbales del tuteo", "Formas verbales de tuteo y voseo", "Solo formas verbales de voseo"}));
		panel_19.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Posterior a la reforma", "Anterior a la reforma", "Ambos"}));
		panel_19.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Espa\u00F1ol", "Franc\u00E9s", "Gallego", "Ingl\u00E9s", "Portugu\u00E9s"}));
		panel_19.add(comboBox_3);
	}

}

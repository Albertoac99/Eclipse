package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import controller.ContEstadisticasPublicaPrivada;
import java.awt.Toolkit;


public class EstadisticasPublicaPrivada extends JDialog {

	private static final long serialVersionUID = 1L;
	public static DefaultPieDataset data;
	private final JPanel contentPanel = new JPanel();
	
	public EstadisticasPublicaPrivada() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icono.png"));
		setTitle("Estad\u00EDsticas de casetas P\u00FAblicas/Privadas");
		estadisticasPublicaPrivada();
	}
	
	public void estadisticasPublicaPrivada() {
		setBounds(1100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		data = new DefaultPieDataset();
		
		ContEstadisticasPublicaPrivada.crearGrafica();
		
		JFreeChart chart = ChartFactory.createPieChart("Gráfico casetas Públicas/Privadas" , data, true, true, false);
		
		chart.setBackgroundPaint((new Color(199,238,174)));
		chart.getTitle().setPaint((new Color(255,78,34)));		
		
		ChartPanel frameG = new ChartPanel(chart);
		
		frameG.setBounds(0,0,300,250);
		
		getContentPane().add(frameG);
		
	}

}

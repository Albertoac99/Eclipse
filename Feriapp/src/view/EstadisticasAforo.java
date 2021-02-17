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
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import controller.ContEstadisticasAforo;
import java.awt.Toolkit;

public class EstadisticasAforo extends JDialog {

	private static final long serialVersionUID = 1L;
	public static DefaultCategoryDataset data;
	private final JPanel contentPanel = new JPanel();

	public EstadisticasAforo() {
		setTitle("Estad\u00EDsticas de aforo");
		setIconImage(Toolkit.getDefaultToolkit().getImage("img\\icono.png"));
		estadisticasAforo();
	}
	
	public void estadisticasAforo() {
		setBounds(1100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		data = new DefaultCategoryDataset();
		
		ContEstadisticasAforo.crearGrafica();
		
		JFreeChart gra = ChartFactory.createBarChart("Aforo por caseta", "Caseta", "Aforo", data, PlotOrientation.VERTICAL, true, true, false);
		
		gra.setBackgroundPaint((new Color(199,238,174)));
		gra.getTitle().setPaint(new Color(255,78,34));
		
		ChartPanel frameG2 = new ChartPanel(gra);
		frameG2.setSize(315,250);
		frameG2.setLocation(350, 0);
		
		getContentPane().add(frameG2);
	}

}

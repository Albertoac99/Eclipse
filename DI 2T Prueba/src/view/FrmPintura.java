package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.event.PlotChangeListener;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.chart.plot.dial.DialBackground;
import org.jfree.chart.plot.dial.DialPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import controller.ControllerFrm;

public class FrmPintura extends JFrame {
	public static DefaultPieDataset data;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPintura frame = new FrmPintura();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FrmPintura() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		
		
		//Fuente de datos
		data = new DefaultPieDataset();
		
		ControllerFrm.establecerConexión();
		
		
		JFreeChart chart = ChartFactory.createPieChart("Ejemplo de gráfico" , data, true, true, false);
		
		
		ChartPanel frameG = new ChartPanel(chart);
		
		frameG.setBounds(0,0,300,250);
		
		contentPane.add(frameG);
		
		
		DefaultCategoryDataset data2 = new DefaultCategoryDataset();
		data2.addValue(8, "Mujeres", "Lunes");
		data2.addValue(2, "Hombres", "Martes");
		data2.addValue(3, "Mujeres", "Miercoles");
		data2.addValue(5, "Hombres", "Sabado");
		data2.addValue(7, "Hombres", "Jueves");
		data2.addValue(9, "Mujeres", "Viernes");
		data2.addValue(1, "Hombres", "Domingo");
		data2.addValue(8, "Mujeres", "Miercoles");
		data2.addValue(2, "Hombres", "Viernes");
		data2.addValue(4, "Mujeres", "Lunes");
		
		JFreeChart gra = ChartFactory.createBarChart("Participacion por Genero", "Genero", "Dias", data2, PlotOrientation.VERTICAL, true, true, false);
		
		gra.setBackgroundPaint(Color.cyan);
		gra.getTitle().setPaint(Color.cyan);
		
		ChartPanel frameG2 = new ChartPanel(gra);
		frameG2.setSize(315,250);
		frameG2.setLocation(350, 0);
		
		//contentPane.add(frameG2);
		
		
	}

}

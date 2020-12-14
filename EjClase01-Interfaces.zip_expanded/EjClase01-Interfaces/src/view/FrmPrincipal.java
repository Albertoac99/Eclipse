package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;

import controller.PrincipalController;
import java.awt.GridLayout;

public class FrmPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static FrmPrincipal frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new FrmPrincipal();
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
	public FrmPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 488, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		try {
			// Fuente de datos y Creando grafico - Pie
			JFreeChart chart = ChartFactory.createPieChart("EMPxJOB", PrincipalController.contruirPieJob(), true, true,
					false);
			contentPane.setLayout(new GridLayout(0, 1, 0, 0));

			JPanel pie = new JPanel();
			contentPane.add(pie);
			pie.setLayout(new GridLayout(1, 2, 0, 0));

			// Mostrar Grafico
			ChartPanel frameG = new ChartPanel(chart);
			pie.add(frameG);
			frameG.setBounds(0, 0, 300, 250);

			// ---------------------------------------------------------------------------------------------------------------------------

			// Fuente de datos y Creando grafico - Pie
			JFreeChart chart2 = ChartFactory.createPieChart("EMPxDEPT", PrincipalController.contruirPieDept(), true,
					true, false);

			// Mostrar Grafico
			ChartPanel frameG2 = new ChartPanel(chart2);
			pie.add(frameG2);
			frameG2.setBounds(0, 0, 300, 250);
			// ---------------------------------------------------------------------------------------------------------------------------
			// Creando grafico - Bar
			JFreeChart gra = ChartFactory.createBarChart("Variacion salarios", "Departamento", "Salario",
					PrincipalController.salario(), PlotOrientation.VERTICAL, true, true, false);

			// Mostrar Grafico
			ChartPanel frameG3 = new ChartPanel(gra);
			frameG3.setBounds(0, 0, 300, 250);

			contentPane.add(frameG3);

		} catch (SQLException e) {
			System.out.println("Error añadiendo la grafica al panel principal: " + e.getMessage());
		}

	}

}

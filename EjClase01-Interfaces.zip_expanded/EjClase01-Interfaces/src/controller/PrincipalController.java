package controller;

import java.sql.SQLException;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import logic.LogicPrincipal;

public class PrincipalController {

	public static DefaultPieDataset contruirPieJob() throws SQLException {

		DefaultPieDataset data = new DefaultPieDataset();

		LogicPrincipal.pedirDatosJob().forEach((k, v) -> data.setValue(k, v));

		return data;
	}

	public static DefaultPieDataset contruirPieDept() throws SQLException {

		DefaultPieDataset data = new DefaultPieDataset();

		LogicPrincipal.pedirDatosDept().forEach((k, v) -> data.setValue(k, v));

		return data;
	}

	public static DefaultCategoryDataset salario() throws SQLException {

		DefaultCategoryDataset data2 = new DefaultCategoryDataset();

		LogicPrincipal.pedirSalario().forEach((k, v) -> {

			data2.setValue(v.get(0), "maximo", k);
			data2.setValue(v.get(1), "minimo", k);
			
			data2.setValue(v.get(2), "maximo", k);
			data2.setValue(v.get(3), "minimo", k);
			
			data2.setValue(v.get(4), "maximo", k);
			data2.setValue(v.get(5), "minimo", k);

		});

		return data2;
	}
}

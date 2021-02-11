package utils;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Caseta;

public class GUI {

public static DefaultTableModel generarTabla(List<Caseta> resultado) throws SQLException {
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		modelo.addColumn("NumeroCaseta");
		modelo.addColumn("NombreCaseta");
		modelo.addColumn("NombreCalle");
		modelo.addColumn("AforoMaximo");
		modelo.addColumn("AforoActual");
		modelo.addColumn("Horario");
		modelo.addColumn("TipoCaseta");
		
		for(Caseta c : resultado) {
				
		modelo.addRow(new Object[] {c.getNumeroCaseta(),c.getNombreCaseta(),c.getNombreCalle(),c.getAforoMaximo(),c.getAforoActual(),c.getHorario(),c.getTipoCaseta()});

		}
		
		return modelo;
	}
	
}

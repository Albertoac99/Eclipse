package utils;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.swing.table.DefaultTableModel;

import model.Coche;

public class GUI {

	public static DefaultTableModel generarTabla(CachedRowSet resultado) throws SQLException {
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		ResultSetMetaData md = resultado.getMetaData();
		
		int totalColumnas = md.getColumnCount();
		
		// Añadir la cabecera de la columna 
		
		for(int col=1; col<= totalColumnas; col++) {
			
			modelo.addColumn(md.getColumnName(col));
		}
		
		// Añadir cada fila de valores
		
		String [] fila = new String[totalColumnas];
		
		while(resultado.next()) {
			
			for(int col=1; col<=totalColumnas;col++) {
				
				fila[col-1] = resultado.getString(col);
				
			}
			
			modelo.addRow(fila);
		}
		
		return modelo;
	}

	public static DefaultTableModel generarTableCoches(List<Coche> resultado) {
		
		DefaultTableModel modelo = new DefaultTableModel();
		
		// Añadir la cabecera de la columna 
		
		modelo.addColumn("#");
		modelo.addColumn("MARCA");
		modelo.addColumn("MODELO");
		
		// Añadir cada fila de valores
		
		for(Coche c : resultado) {
			modelo.addRow(new Object[] {c.getIdCoche(), c.getMarca(), c.getModelo()});
		}
		
		
		return modelo;
	}

}

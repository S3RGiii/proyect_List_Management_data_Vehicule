package co.edu.uptc.model;

import java.util.List;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class GeographicAnalysis {
    
    public List<String> getRecordsByState() {
        // Lógica para obtener la cantidad de registros por estado
        return null; // Retorna una lista de registros
    }

    //jose la tiene pequeña
    public TableModel createTableModelFromList(List<String> records) {
    String[] columnNames = {"County"};
    Object[][] data = new Object[records.size()][1];
    
    for (int i = 0; i < records.size(); i++) {
        data[i][0] = records.get(i);
    }
    
    return new DefaultTableModel(data, columnNames);
}
    
    public List<String> getRecordsByCounty() {
        // Lógica para obtener la cantidad de registros por condado
        return null;
    }

    public String getCityWithMostVehicles() {
        // Lógica para obtener la ciudad con más vehículos
        return null;
    }
}

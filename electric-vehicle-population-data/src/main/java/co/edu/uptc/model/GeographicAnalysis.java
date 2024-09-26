package co.edu.uptc.model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import co.edu.uptc.utils.LinkedListSorter;
import co.edu.uptc.utils.MyList;
import co.edu.uptc.utils.Node;

public class GeographicAnalysis {
    private MyList<Vehicule> records;
    private LinkedListSorter<Vehicule> sorter;


    public GeographicAnalysis(MyList<Vehicule> records) {
        this.records = records;
        sorter = new LinkedListSorter<>();
    }
    public TableModel getRecordsByCountyAndState() {
        MyList<Vehicule> sortedRecords =getRecordsByState();
        DefaultTableModel tableModel = new DefaultTableModel(new Object[]{"State", "County", "Count"}, 0);

        Set<String> processedCounties = new HashSet<>();  

        sortedRecords.forEach(record -> {
            String state = record.getState();
            String county = record.getCounty();
            
            // Crear una clave única para estado-condado
            String key = state + "-" + county;
        
            // Si ya procesamos este condado, no lo contamos de nuevo
            if (!processedCounties.contains(key)) {
                int count = 0;
        
                // Contamos los vehículos para este estado y condado
                for (Vehicule vehicule : sortedRecords) {
                    if (vehicule.getState().equals(state) && vehicule.getCounty().equals(county)) {
                        count++;
                    }
                }
        
                // Agregamos la fila a la tabla y registramos el condado como procesado
                tableModel.addRow(new Object[]{state, county, count});
                processedCounties.add(key);  // Marcar el condado como procesado
            }
        });
        
        return tableModel;}
    




    @SuppressWarnings("unchecked")
    public MyList<Vehicule> getRecordsByState() {

        Comparator<Vehicule> stateComparator = new Comparator<Vehicule>() {
            @Override
            public int compare(Vehicule o1, Vehicule o2) {
                return o1.getState().compareTo(o2.getState());
            }
        };
        Node<Vehicule> nhead = sorter.sort(records.getHead(), stateComparator);
        records.setHead(nhead);
        return records;
    }

    
    
   
}

package co.edu.uptc.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataPanel extends JPanel {

    public DataPanel() {
        setLayout(new BorderLayout());
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JButton loadJsonButton = new JButton("Leer otro JSON");
        topPanel.add(loadJsonButton);
        
        JLabel dataLabel = new JLabel("DATA");
        dataLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(dataLabel);
        
        add(topPanel, BorderLayout.NORTH);
        
        String[] columnNames = {"Vehículo", "Modelo", "Fecha de Publicación", 
                                "Última modificación", "Ventas", "Acciones"};
        Object[][] data = {
            {"TESLA", "Modelo S", "10/02/2023", "10/02/2023", 210, "★ ✎ ❌"},
            {"Spider-Man", "Multiverse", "10/02/2023", "10/02/2023", 80, "★ ✎ ❌"},
            {"Thor", "Asgardian", "10/02/2023", "10/02/2023", 92, "★ ✎ ❌"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setRowHeight(30); 
        
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setBackground(new Color(40, 40, 40));
        table.setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(60, 60, 60));
        
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableScrollPane.getViewport().setBackground(new Color(40, 40, 40)); 
        
        add(tableScrollPane, BorderLayout.CENTER);
        
        setBackground(new Color(245, 245, 245)); 
    }

   
}

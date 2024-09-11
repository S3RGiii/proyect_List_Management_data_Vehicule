package co.edu.uptc.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class DataPanel extends JPanel {

    public DataPanel() {
        // Configuración del panel principal
        setLayout(new BorderLayout());
        
        // Panel superior con los botones y opciones
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        // Botón "Leer otro JSON"
        JButton loadJsonButton = new JButton("Leer otro JSON");
        topPanel.add(loadJsonButton);
        
        // Etiqueta "DATA"
        JLabel dataLabel = new JLabel("DATA");
        dataLabel.setFont(new Font("Arial", Font.BOLD, 20));
        topPanel.add(dataLabel);
        
        // Añadimos el panel superior al norte del panel principal
        add(topPanel, BorderLayout.NORTH);
        
        // Modelo de tabla
        String[] columnNames = {"Vehículo", "Modelo", "Fecha de Publicación", 
                                "Última modificación", "Ventas", "Acciones"};
        Object[][] data = {
            {"TESLA", "Modelo S", "10/02/2023", "10/02/2023", 210, "★ ✎ ❌"},
            {"Spider-Man", "Multiverse", "10/02/2023", "10/02/2023", 80, "★ ✎ ❌"},
            {"Thor", "Asgardian", "10/02/2023", "10/02/2023", 92, "★ ✎ ❌"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setRowHeight(30); // Altura de las filas
        
        // Estilo de la tabla
        table.setFont(new Font("Arial", Font.PLAIN, 14));
        table.setBackground(new Color(40, 40, 40));
        table.setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(60, 60, 60));
        
        // Panel que contiene la tabla
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableScrollPane.getViewport().setBackground(new Color(40, 40, 40)); // Fondo de la tabla
        
        // Añadimos la tabla al centro del panel
        add(tableScrollPane, BorderLayout.CENTER);
        
        // Configuración del panel en su totalidad
        setBackground(new Color(245, 245, 245)); // Color de fondo del panel
    }

   
}

 package co.edu.uptc.view;
import javax.swing.*;
import java.awt.*;

public class GeographicAnalysisView extends JFrame {
    
    private JTable tableByState;
    private JTable tableByCounty;
    private JLabel cityLabel;
    
    public GeographicAnalysisView() {
        setTitle("Análisis Geográfico");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(3, 1));

        // Tabla de registros por estado
        tableByState = new JTable();
        mainPanel.add(new JScrollPane(tableByState));

        // Tabla de registros por condado
        tableByCounty = new JTable();
        mainPanel.add(new JScrollPane(tableByCounty));

        // Etiqueta de la ciudad con más vehículos
        cityLabel = new JLabel("Ciudad con más vehículos: ");
        mainPanel.add(cityLabel);

        add(mainPanel, BorderLayout.CENTER);
    }

    public JTable getTableByState() {
        return tableByState;
    }

    public JTable getTableByCounty() {
        return tableByCounty;
    }

    public JLabel getCityLabel() {
        return cityLabel;
    }
}

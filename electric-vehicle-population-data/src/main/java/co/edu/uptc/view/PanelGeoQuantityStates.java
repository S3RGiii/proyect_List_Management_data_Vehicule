package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class PanelGeoQuantityStates extends JPanel {
    private static final long serialVersionUID = 1L;

    private JLabel textTittle, subText;
    private JPanel panelTexts, panelTable;

    public PanelGeoQuantityStates(TableModel model) { 
        setLayout(new BorderLayout());
        initComponents(model);
    }

    private void initComponents(TableModel table) {

        panelTexts = new JPanel();
        panelTexts.setLayout(new BoxLayout(panelTexts, BoxLayout.Y_AXIS));

        textTittle = new JLabel("Cantidad de Registros Por estado");
        panelTexts.add(textTittle);
        subText = new JLabel("Ordenada de mayor a menor");
        panelTexts.add(subText);

        this.add(panelTexts, BorderLayout.NORTH);

        panelTable = new JPanel(new BorderLayout()); // Asegurarse de usar BorderLayout en panelTable
        String[] columnNames = {"Estados", "Cantidad"};
        Object[][] data = {
            {"TESLA", "200"},
            {"Spider-Man", "1000"},
            {"Thor", "5000"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table1 = new JTable(table);
        table1.setRowHeight(30);

        table1.setBackground(new Color(40, 40, 40));
        table1.setForeground(Color.WHITE);
        table1.setSelectionBackground(new Color(60, 60, 60));

        JScrollPane tableScrollPane = new JScrollPane(table1);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableScrollPane.getViewport().setBackground(new Color(40, 40, 40)); 
        
        panelTable.add(tableScrollPane, BorderLayout.CENTER); // Añadir el JScrollPane al centro de panelTable

        setBackground(new Color(245, 245, 245)); 
        this.add(panelTable, BorderLayout.CENTER); // Asegurarse de añadir panelTable en el centro de todo el layout
    }
}

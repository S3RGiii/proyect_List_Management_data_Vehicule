package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class PanelGeoListCity extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel textTittle ,subText;
	private JPanel panelTexts , panelTable;

	public PanelGeoListCity( ) { 
		setLayout(new BorderLayout() );
		initComponents();
	}

	/**
	 * 
	 */
	private void initComponents(  ) {

		panelTexts = new JPanel();
		panelTexts.setLayout(new BoxLayout(panelTexts,BoxLayout.Y_AXIS));
		
		textTittle = new JLabel("Ciudad Mayor Cantidad de Veiculos");
		panelTexts.add(textTittle);
		subText = new JLabel("Ordenada de mayor a menor");
		panelTexts.add(subText);

		this.add(panelTexts,BorderLayout.NORTH);

		panelTable = new JPanel();
		String[] columnNames = {"Ciudad", "Vehiculos"};
        Object[][] data = {
            {"tunja", "1000"},
            {"Sachica","1000" },
            {"togui", "1000"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        table.setRowHeight(30); 
        
        table.setBackground(new Color(40, 40, 40));
        table.setForeground(Color.WHITE);
        table.setSelectionBackground(new Color(60, 60, 60));
        
        JScrollPane tableScrollPane = new JScrollPane(table);
        tableScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        tableScrollPane.getViewport().setBackground(new Color(40, 40, 40)); 
        
        panelTable.add(tableScrollPane, BorderLayout.CENTER);
        
        setBackground(new Color(245, 245, 245)); 
		this.add(panelTable);



	


		
	}		
	
		
		
 
		
	
		
		
	

	



}

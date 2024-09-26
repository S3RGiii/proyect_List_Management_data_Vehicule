package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class PanelGenerico extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JLabel textTittle ,subText;
	private JPanel panelTexts , panelTable;
	private String[] columnNames  ;
	private   Object[][] data ;

	public PanelGenerico( String tittle, String subTittle , String [] colNames , Object [][]dataTable) { 
		textTittle = new JLabel(tittle);
		subText = new JLabel(subTittle);
		this.columnNames =colNames ;
		this.data =  dataTable;
		setLayout(new BorderLayout() );
		initComponents();
	}

	/**
	 * 
	 */
	private void initComponents(  ) {

		panelTexts = new JPanel();
		panelTexts.setLayout(new BoxLayout(panelTexts,BoxLayout.Y_AXIS));
		
		
		panelTexts.add(textTittle);
		panelTexts.add(subText);

		this.add(panelTexts,BorderLayout.NORTH);

		panelTable = new JPanel();

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

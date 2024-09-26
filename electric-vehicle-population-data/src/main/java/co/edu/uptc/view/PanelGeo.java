package co.edu.uptc.view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.*;
import javax.swing.table.TableModel;

import co.edu.uptc.controller.Actions;
import co.edu.uptc.controller.Controller;
import co.edu.uptc.interfaces.IGeoPanelView;




public class PanelGeo extends JPanel implements IGeoPanelView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelsButtons,panelCenter;
	private JButton buttonOpcionUno,buttonOpcionDos,buttonOpcionTres;
	

	public PanelGeo(Controller control ) { 
		setLayout(new BorderLayout() );
		initComponents(control);
	}

	private void initComponents( Controller control ) {
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		// Crear panel para botones con BoxLayout en Y_AXIS
		panelsButtons = new JPanel();
		panelsButtons.setBackground(Color.decode("#737373"));
		panelsButtons.setLayout(new BoxLayout(panelsButtons, BoxLayout.Y_AXIS));
		
		buttonOpcionUno = new JButton("Registros por Estado");
		buttonOpcionUno.setBackground(Color.decode("#DCDCDC"));
		buttonOpcionUno.setForeground(Color.BLACK);
		buttonOpcionUno.addActionListener(control);
		buttonOpcionUno.setActionCommand(Actions.BUTTON_GEO_OPCIONONE.toString());
		buttonOpcionUno.setPreferredSize(new Dimension(180, 45));
		buttonOpcionUno.setMaximumSize(buttonOpcionUno.getPreferredSize());
		
		buttonOpcionDos = new JButton("Registros por Condado");
		buttonOpcionDos.setBackground(Color.decode("#DCDCDC"));
		buttonOpcionDos.setForeground(Color.BLACK);
		buttonOpcionDos.addActionListener(control);
		buttonOpcionDos.setActionCommand(Actions.BUTTON_GEO_OPCIONDOS.toString());
		buttonOpcionDos.setPreferredSize(new Dimension(180, 45));
		buttonOpcionDos.setMaximumSize(buttonOpcionDos.getPreferredSize());


		JLabel labelOpcionTres = new JLabel("<html>Ciudad con mas <br>Vehiculos</html>", SwingConstants.CENTER);

		buttonOpcionTres = new JButton(labelOpcionTres.getText());
		buttonOpcionTres.setBackground(Color.decode("#DCDCDC"));
		buttonOpcionTres.setForeground(Color.BLACK);
		buttonOpcionTres.addActionListener(control);
		buttonOpcionTres.setActionCommand(Actions.BUTTON_GEO_OPCIONTRES.toString());
		buttonOpcionTres.setPreferredSize(new Dimension(180, 45));
		buttonOpcionTres.setMaximumSize(buttonOpcionTres.getPreferredSize());
		
		
		panelsButtons.add(Box.createRigidArea(new Dimension(0, 10))); 
		panelsButtons.add(buttonOpcionUno);
		panelsButtons.add(Box.createRigidArea(new Dimension(0, 10)));
		panelsButtons.add(buttonOpcionDos);
		panelsButtons.add(Box.createRigidArea(new Dimension(0, 10)));
		panelsButtons.add(buttonOpcionTres);
		
		
		JPanel leftMargin = new JPanel();
		leftMargin.setPreferredSize(new Dimension(20, 0));  
		leftMargin.setBackground(Color.decode("#737373"));  
		
		JPanel rightMargin = new JPanel();
		rightMargin.setPreferredSize(new Dimension(20, 0));  
		rightMargin.setBackground(Color.decode("#737373"));  
		
		JPanel centeredPanel = new JPanel();
		centeredPanel.setLayout(new BorderLayout());
		centeredPanel.add(leftMargin, BorderLayout.WEST); 
		centeredPanel.add(rightMargin, BorderLayout.EAST);  
		centeredPanel.add(panelsButtons, BorderLayout.CENTER);  
		
		mainPanel.add(centeredPanel, BorderLayout.CENTER);
		
		
		this.add(mainPanel,BorderLayout.WEST);
		panelCenter = new PanelGeoQuantityStates(null);
		this.add(panelCenter);


		
	}

	@Override
	public void addPanel(JPanel panel) {
		remove(panelCenter);
		this.panelCenter = panel;
		this.add(panelCenter, BorderLayout.CENTER);
		repaint();
		revalidate();
    }		

	
		
		
 
		
	
		
		
	

	



}

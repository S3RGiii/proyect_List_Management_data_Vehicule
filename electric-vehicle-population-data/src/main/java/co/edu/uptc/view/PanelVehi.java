package co.edu.uptc.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

import co.edu.uptc.controller.Actions;
import co.edu.uptc.controller.Controller;


public class PanelVehi extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panelsButtons,panelCenter;
	private JButton buttonOpcionUno,buttonOpcionDos,buttonOpcionTres;
	private JLabel labelCenter;
	private Controller control;

	public PanelVehi( Controller control) {
		this.control=control; 
		this.setBackground(Color.decode("#737373"));
		setLayout(new BorderLayout() );
		initComponents();
	}

	private void initComponents(  ) {

	// Crear panel principal con BorderLayout
JPanel mainPanel = new JPanel();
mainPanel.setLayout(new BorderLayout());

// Crear panel para botones con BoxLayout en Y_AXIS
panelsButtons = new JPanel();
panelsButtons.setBackground(Color.decode("#737373"));
panelsButtons.setLayout(new BoxLayout(panelsButtons, BoxLayout.Y_AXIS));

// Crear los botones con el tamaño y estilo especificado
buttonOpcionUno = new JButton("Vehiculos por Modelo");
buttonOpcionUno.setBackground(Color.decode("#DCDCDC"));
buttonOpcionUno.setForeground(Color.BLACK);
buttonOpcionUno.addActionListener(control);
buttonOpcionUno.setActionCommand(Actions.BUTTON_VEH_OPCIONONE.toString());
buttonOpcionUno.setPreferredSize(new Dimension(180, 45));
buttonOpcionUno.setMaximumSize(buttonOpcionUno.getPreferredSize());

buttonOpcionDos = new JButton("Vehiculos por Fabricante");
buttonOpcionDos.setBackground(Color.decode("#DCDCDC"));
buttonOpcionDos.setForeground(Color.BLACK);
buttonOpcionDos.addActionListener(control);
buttonOpcionDos.setActionCommand(Actions.BUTTON_VEH_OPCIONDOS.toString());
buttonOpcionDos.setPreferredSize(new Dimension(180, 45));
buttonOpcionDos.setMaximumSize(buttonOpcionDos.getPreferredSize());

JLabel labelOpcionTres = new JLabel("<html>Vehiculos por<br>Rango Electrico</html>", SwingConstants.CENTER);

// Añadir el JLabel a un JButton si es necesario
JButton buttonOpcionTres = new JButton(labelOpcionTres.getText());
buttonOpcionTres.setBackground(Color.decode("#DCDCDC"));
buttonOpcionTres.setForeground(Color.BLACK);

buttonOpcionTres.addActionListener(control);
buttonOpcionTres.setActionCommand(Actions.BUTTON_VEH_OPCIONTRES.toString());


// Añadir espacio y botones al panel de botones
panelsButtons.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio superior
panelsButtons.add(buttonOpcionUno);
panelsButtons.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botones
panelsButtons.add(buttonOpcionDos);
panelsButtons.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre botones
panelsButtons.add(buttonOpcionTres);

// Crear un panel para los márgenes con color de fondo
JPanel leftMargin = new JPanel();
leftMargin.setPreferredSize(new Dimension(20, 0));  // Tamaño del margen
leftMargin.setBackground(Color.decode("#737373"));  // Color de fondo rojo

JPanel rightMargin = new JPanel();
rightMargin.setPreferredSize(new Dimension(20, 0));  // Tamaño del margen
rightMargin.setBackground(Color.decode("#737373"));  // Color de fondo rojo

// Crear un panel para centrar los botones
JPanel centeredPanel = new JPanel();
centeredPanel.setLayout(new BorderLayout());
centeredPanel.add(leftMargin, BorderLayout.WEST);  // Margen a la izquierda
centeredPanel.add(rightMargin, BorderLayout.EAST);  // Margen a la derecha
centeredPanel.add(panelsButtons, BorderLayout.CENTER);  // Panel de botones centrado

// Añadir el panel centrado al panel principal
mainPanel.add(centeredPanel, BorderLayout.CENTER);

// Añadir el panel principal al JFrame o al panel contenedor

// Añadir el panel principal al JFrame o al panel contenedor
this.add(mainPanel,BorderLayout.WEST);

		panelCenter = new JPanel();
		panelCenter.setBackground(Color.GREEN);

	

		String tittlePanel= "Cantidad de vehículos por modelo del vehículo";
		String nameCol []= {"Modelo ","Cantidad"};
		Object[][] data = {
		   {"asda", "1000"},
		   {"sss","1000" },
		   {"asdddas", "1000"}
	   };
	    panelCenter= new PanelGenerico(tittlePanel,"",nameCol,data);
		this.add(panelCenter);


		
	}		
	
		
	public void addPanel(JPanel panel) {
		remove(panelCenter);
		this.panelCenter = panel;
		this.add(panelCenter, BorderLayout.CENTER);
		repaint();
		revalidate();
    }	
		
 
		
	
		
		
	

	



}

package co.edu.uptc.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import java.awt.*;

import co.edu.uptc.controller.Actions;
import co.edu.uptc.controller.Controller;
import co.edu.uptc.interfaces.IWindowsView;




public class Windows extends JFrame implements IWindowsView {

	private static final long serialVersionUID = 1L;
	private PanelGeo geo;
	private PanelVehi panelVehi;
	private JPanel panelsButtonsTop,panelCenter;
	private JButton buttonModuleVehicle,buttonModuleGeo ;
	private JLabel labelPrincipal;
	private String [] nameCol;
	private String tittlePanel;
	private Object[][] data;
	Controller control;

	public Windows(Controller control) {
		this.control=control;
		this.geo = new PanelGeo(control);
		this.panelVehi = new PanelVehi(control);
		setTitle("Electric Vehicle Population");
		setLayout(new BorderLayout());
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		ImageIcon icono = new ImageIcon(getClass().getClassLoader().getResource("tesla_logo.png"));
        setIconImage(icono.getImage());
		

			setLocationRelativeTo(null);
		setResizable(true);
		initComponents();

	}

	private void initComponents() {

		panelsButtonsTop = new JPanel();
		panelsButtonsTop.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 14));
		panelsButtonsTop.setBackground(Color.white);

		buttonModuleGeo = new JButton("Modulo Geografico");
		buttonModuleGeo.setBackground(Color.decode("#DCDCDC"));
		buttonModuleGeo.setForeground(Color.black);
		buttonModuleGeo.addActionListener(control);
		buttonModuleGeo.setActionCommand(Actions.BUTTON_ANALISIS_GEO.toString());
		buttonModuleGeo.setPreferredSize(new Dimension(150, 50));
		panelsButtonsTop.add(buttonModuleGeo);


		buttonModuleVehicle = new JButton("Modulo Vehiculo");
		buttonModuleVehicle.setBackground(Color.decode("#DCDCDC"));
		buttonModuleVehicle.setForeground(Color.BLACK);
		buttonModuleVehicle.addActionListener(control);
		buttonModuleVehicle.setActionCommand(Actions.BUTTON_ANALISIS_VEHI.toString());
		buttonModuleVehicle.setPreferredSize(new Dimension(150, 50));

		panelsButtonsTop.add(buttonModuleVehicle);

		this.add(panelsButtonsTop,BorderLayout.NORTH);

		panelCenter=new JPanel();
		panelCenter.setBackground(Color.BLUE);
		labelPrincipal = new JLabel("Hola esta es la pagina Principal");
		labelPrincipal.setForeground(Color.white);
		panelCenter.add(labelPrincipal);

		this.add(panelCenter, BorderLayout.CENTER);
	}



	@Override
	public void showVehiclePanel() {
		remove(panelCenter);
		this.panelCenter = panelVehi;
		this.add(panelCenter, BorderLayout.CENTER);
		repaint();
		revalidate();

	}


	@Override
	public void showGeoPanel() {
		remove(panelCenter);
		this.panelCenter = geo;
		this.add(panelCenter, BorderLayout.CENTER);
		repaint();
		revalidate();
	}
	
	@Override
	public void showQuantityStatesPanel(TableModel model) {
		geo.addPanel(new PanelGeoQuantityStates(model));
	}
	
	@Override
	public void showCountyPanel() {
		geo.addPanel(new PanelGeoListCounty());
	}

	@Override
	public void showListCityPanel() {
		geo.addPanel(new PanelGeoListCity());
	}

	@Override
	public void showVehiOne() {
		 tittlePanel= "Cantidad de vehículos por modelo del vehículo";
		 nameCol= new String[] {"Modelo ","Cantidad"};
		  data = new Object[][] {
            {"asda", "1000"},
            {"sss","1000" },
            {"asdddas", "1000"}
        };
				panelVehi.addPanel(new PanelGenerico(tittlePanel,"",nameCol,data));

	}

	@Override
	public void showVehiTwo() {
		 tittlePanel= "Cantidad de vehículo por fabricante";
		 nameCol= new String[] {"Fabricante ","Cantidad"};
		 data = new Object[][] {
            {"21", "1000"},
            {"323","1000" },
            {"323", "1000"}
        };
				panelVehi.addPanel(new PanelGenerico(tittlePanel,"",nameCol,data));

	}

	@Override
	public void showVehiThree() {

		nameCol= new String[] {"Rango Electrico ","Cantidad"};
		 tittlePanel= "Cantidad de vehículos por rango eléctrico";
		data =new Object[][]  {
            {"444", "1000"},
            {"222","1000" },
            {"111", "1000"}
        };
				panelVehi.addPanel(new PanelGenerico(tittlePanel,"",nameCol,data));

	}
}

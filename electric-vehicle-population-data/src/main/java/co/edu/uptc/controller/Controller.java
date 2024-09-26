package co.edu.uptc.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.model.GeographicAnalysis;
import co.edu.uptc.model.Vehicule;
import co.edu.uptc.model.VehiculeMapper;
import co.edu.uptc.model.data.Root;
import co.edu.uptc.net.Connection;
import co.edu.uptc.view.Windows;

public class Controller implements ActionListener {
    
    private GeographicAnalysis model;
    private Connection connection;
    private ObjectMapper objectMapper;
	private Windows windows;
	private int option = 0;

    public Controller() {
        connection = new Connection();
        objectMapper = new ObjectMapper();
        System.out.println("Presenter  0");
        windows = new Windows(this);
        System.out.println("Presenter  1");
        model = new GeographicAnalysis(connection.giveData());
		windows.setVisible(true);
         
         System.out.println("Presenter");
         // view = new MainView(this); linea que inicializa la vista
		     


    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Actions.valueOf(e.getActionCommand())) {
		case BUTTON_ANALISIS_GEO:
			windows.showGeoPanel();
			break;
		case BUTTON_ANALISIS_VEHI:
			windows.showVehiclePanel();
			break;
		case BUTTON_GEO_OPCIONONE:
			windows.showQuantityStatesPanel(model.getRecordsByCountyAndState());

		break;
		case BUTTON_GEO_OPCIONDOS:
			windows.showCountyPanel();
		break;
		case BUTTON_GEO_OPCIONTRES:
			windows.showListCityPanel();
		break;
		case 	BUTTON_VEH_OPCIONONE:
		windows.showVehiOne();
		break;
case 	BUTTON_VEH_OPCIONDOS:
windows.showVehiTwo();

break;
case 	BUTTON_VEH_OPCIONTRES:
windows.showVehiThree();;

break;

		case EXIT:
			option = 6;
			JOptionPane.showMessageDialog(null, "la aplicacion ha finalizado");
			System.exit(0);
			break;
		default:
			break;

		}

	}


	public int getOption() {
		return option;
	}


}
    
  
            
               
                
        

        


  





package co.edu.uptc.interfaces;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public interface IWindowsView {
   public void showGeoPanel();
   public void showVehiclePanel();
   void showQuantityStatesPanel(TableModel model);
   void showCountyPanel();
   void showListCityPanel();
   void showVehiOne();
   void showVehiTwo();
   void showVehiThree();

    
}

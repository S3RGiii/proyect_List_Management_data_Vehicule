package co.edu.uptc.model;

import java.util.ArrayList;
import java.util.List;

public class VehiculeMapper {

    public static Vehicule mapToVehiculo(ArrayList<Object> dates) {
        Vehicule vehiculo = new Vehicule();
        
        if (dates.get(8) != null) vehiculo.setVin((String) dates.get(8));
        if (dates.get(9) != null) vehiculo.setCounty((String) dates.get(9));
        if (dates.get(10) != null) vehiculo.setCity((String) dates.get(10));
        if (dates.get(11) != null) vehiculo.setState((String) dates.get(11));
        if (dates.get(12) != null) vehiculo.setZipCode((String) dates.get(12));
        if (dates.get(13) != null) vehiculo.setModelYear((String) dates.get(13));
        if (dates.get(14) != null) vehiculo.setMake((String) dates.get(14));
        if (dates.get(15) != null) vehiculo.setModel((String) dates.get(15));
        if (dates.get(16) != null) vehiculo.setEvType((String) dates.get(16));
        if (dates.get(17) != null) vehiculo.setCafvType((String) dates.get(17));
        if (dates.get(18) != null) vehiculo.setElectricRange(Integer.parseInt((String) dates.get(18)));
        if (dates.get(19) != null) vehiculo.setBaseMsrp(Integer.parseInt((String) dates.get(19)));
        if (dates.get(20) != null) vehiculo.setDolVehicleId((String) dates.get(20));
        if (dates.get(21) != null) vehiculo.setVehicleLocation((String) dates.get(21));
        if (dates.get(22) != null) vehiculo.setElectricUtility((String) dates.get(22));

        return vehiculo;
    }
}

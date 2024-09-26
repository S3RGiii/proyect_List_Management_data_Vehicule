package co.edu.uptc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Vehicule {
    
    private String vin;
    private String county;
    private String city;
    private String state;
    private String zipCode;
    private String modelYear;
    private String make;
    private String model;
    private String evType;
    private String cafvType;
    private int electricRange;
    private int baseMsrp;
    private String dolVehicleId;
    private String vehicleLocation;
    private String electricUtility;    
}

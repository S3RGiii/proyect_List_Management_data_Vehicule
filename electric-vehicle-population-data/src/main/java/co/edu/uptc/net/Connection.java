package co.edu.uptc.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.model.Vehicule;
import co.edu.uptc.model.VehiculeMapper;
import co.edu.uptc.model.data.Root;
import co.edu.uptc.utils.MyList;

public class Connection {


    public MyList<Vehicule> giveData(){
            String data=null;
            Root root=null;
            ObjectMapper objectMapper= new ObjectMapper();
            MyList<Vehicule> list = new MyList();

            try {
                data = getJsonData("https://data.wa.gov/api/views/f6w7-q2d2/rows.json?accessType=DOWNLOAD");
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            try {
                root = objectMapper.readValue(data, Root.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            String info="";
            int i=0;
            for (ArrayList<Object> dates : root.data) {
               list.add(VehiculeMapper.mapToVehiculo(dates));
              /*  if (i==20) {break;
               }else{
                     i++;
               }*/
               }
               return list;

        
    }

    private String getJsonData(String urlParam) throws IOException {
        URL url = new URL(urlParam);
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        try {
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                                                                
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();
            } else {
                response.append("ERROR");
            }
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();}
        return response.toString();
    }

}
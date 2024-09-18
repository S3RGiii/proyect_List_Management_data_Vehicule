package co.edu.uptc.presenter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.uptc.model.GeographicAnalysis;
import co.edu.uptc.model.data.Root;
import co.edu.uptc.view.MainView;
import co.edu.uptc.net.Connection;

public class Presenter {
    
    private GeographicAnalysis model;
    private MainView view;
    private Connection connection;
    private ObjectMapper objectMapper;

    public Presenter(GeographicAnalysis model, MainView view) {
        this.model = model;
        this.view = view;
        connection = new Connection();
        objectMapper = new ObjectMapper();
        if(loadData()){

        }
      
    }
    
  public boolean loadData(){
    try {
            String data = connection.getJsonData("https://data.wa.gov/api/views/f6w7-q2d2/rows.json?accessType=DOWNLOAD");
            Root root = objectMapper.readValue(data, Root.class);
            String info="";
            for (ArrayList<Object> dates : root.data) {
              for (int i = 1; i <= 17; i++) {
                info="null";
                if (dates.get(i)!=null) {
                     info=  dates.get(i).toString();
                     info+= " "+i;

                    
                }


                
             
                System.out.println(info);
                
              }
              break;
                
               }
            
               
                
            } catch (IOException e) {
                return false;
            }

            return true;
        }

        


  }





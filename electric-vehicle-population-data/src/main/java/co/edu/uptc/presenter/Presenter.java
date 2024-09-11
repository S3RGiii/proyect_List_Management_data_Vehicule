package co.edu.uptc.presenter;

import co.edu.uptc.model.GeographicAnalysis;
import co.edu.uptc.view.MainView;

public class Presenter {
    
    private GeographicAnalysis model;
    private MainView view;

    public Presenter(GeographicAnalysis model, MainView view) {
        this.model = model;
        this.view = view;

        // Pide los datos del modelo y los muestra en la vista
        //view.getTableByState().setModel(model.getRecordsByState());
        //  view.getTableByCounty().setModel(model.getRecordsByCounty());
    }
    
}

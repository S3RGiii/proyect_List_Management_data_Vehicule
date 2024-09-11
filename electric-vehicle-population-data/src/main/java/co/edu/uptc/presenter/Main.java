package co.edu.uptc.presenter;

import co.edu.uptc.model.GeographicAnalysis;
import co.edu.uptc.view.GeographicAnalysisView;
import co.edu.uptc.presenter.Presenter;


public class Main {
    public static void main(String[] args) {
        GeographicAnalysis model = new GeographicAnalysis();
        GeographicAnalysisView view = new GeographicAnalysisView();
        Presenter presenter = new Presenter(model, view);

        view.setVisible(true);
    }
}

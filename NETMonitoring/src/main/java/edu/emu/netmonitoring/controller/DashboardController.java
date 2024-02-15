package edu.emu.netmonitoring.controller;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DashboardController {
    @FXML
    NumberAxis xAxis;
    @FXML
    NumberAxis yAxis;
    @FXML
    LineChart<Number, Number> lineChart;

    // I think this can be moved to a separate function
    public void initialize(){
        
        xAxis.setLabel("Time Interval");
        
        yAxis.setLabel("# of Traffic");

        xAxis.setLabel("Time Interval");
        yAxis.setLabel("# of user traffic");

        final LineChart<Number, Number> lineChart = new LineChart<Number, Number>(xAxis, yAxis);
        XYChart.Series series = new XYChart.Series<>();


        lineChart.setTitle("Demo traffic monitoring on network");
        series.getData().add(new XYChart.Data(1,15));
        series.getData().add(new XYChart.Data(2,9));
        series.getData().add(new XYChart.Data(3,7));
        series.getData().add(new XYChart.Data(4,21));
        series.getData().add(new XYChart.Data(5,23));
        series.getData().add(new XYChart.Data(6,31));
        series.getData().add(new XYChart.Data(7,17));

        lineChart.getData().add(series);
    }
}

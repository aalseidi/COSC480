package edu.emu.netmonitoring;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;
import java.io.IOException;

public class NetMonitoringApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NetMonitoringApplication.class.getResource("/edu/emu/netmonitoring/fxml/dashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1200, 800);

        stage.setTitle("Dashboard");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        
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


        stage.setScene(scene);
        stage.show();






    }

    public static void main(String[] args) {
        launch();
    }
}
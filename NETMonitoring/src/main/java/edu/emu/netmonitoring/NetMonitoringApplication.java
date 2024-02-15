package edu.emu.netmonitoring;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NetMonitoringApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(NetMonitoringApplication.class.getResource("/edu/emu/netmonitoring/fxml/dashboard.fxml"));
        //Scene scene = new Scene(fxmlLoader.load(), 1200, 800);

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
        series.getData().add(new XYChart.Data(6,31));
        series.getData().add(new XYChart.Data(7,17));

        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();

    }
    public static List<String> PingIpAddr(String ip) throws IOException
    {
        ProcessBuilder pb = new ProcessBuilder("ping", ip);
        //ProcessBuilder pb = new ProcessBuilder("ping", "-c 5", ip);
        BufferedReader stdInput = new BufferedReader(new InputStreamReader(pb.start().getInputStream()));        

        while (!stdInput.ready())
        {
            // custom timeout handling
        }

        String line;
        ArrayList<String> output = new ArrayList<>();

        while ((line = stdInput.readLine()) != null)
        {
            output.add(line);
        }

        return output;
    }

    public static void main(String[] args) {
        launch();
    }
}
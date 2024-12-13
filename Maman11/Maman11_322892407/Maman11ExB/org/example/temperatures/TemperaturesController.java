package org.example.temperatures;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class TemperaturesController {

    @FXML
    private Canvas canvas;
    @FXML
    private Button nextYearButton;
    @FXML
    private Label yearLabel;


    private final double[][] temperatureData = {
            {5, 7, 12, 18, 21, 25, 28, 27, 22, 16, 10, 6},   // Year 2024
            {4, 6, 11, 17, 20, 23, 27, 26, 21, 15, 9, 5},    // Year 2023
            {3, 5, 10, 16, 19, 22, 26, 25, 20, 14, 8, 4},     // Year 2022
            {3, 5, 10, 16, 19, 22, 30, 25, 20, 14, 8, 4}     // Year 2021
    };

    private final List<Integer> years = new ArrayList<>();
    private int currentYearIndex = 0;


    @FXML
    public void initialize() {
        generateYears();
        updateYearLabel();
        drawTemperatureData(temperatureData[currentYearIndex]);

        nextYearButton.setOnAction(e -> {
            currentYearIndex = (currentYearIndex + 1) % temperatureData.length;
            updateYearLabel();
            drawTemperatureData(temperatureData[currentYearIndex]);
        });
    }

    private void generateYears() {
        int startYear = 2024;
        int numberOfYears = temperatureData.length;
        for (int i = 0; i < numberOfYears; i++) {
            years.add(startYear - i);  // Start from 2024 and go backwards
        }
    }


    private void updateYearLabel() {
        yearLabel.setText("Year: " + years.get(currentYearIndex));
    }


    private void drawTemperatureData(double[] temperatures) {

        // Find the hottest and coolest month
        double maxTemp = Double.MIN_VALUE;
        double minTemp = Double.MAX_VALUE;

        for (double temp : temperatures) {
            if (temp > maxTemp) maxTemp = temp;
            if (temp < minTemp) minTemp = temp;
        }


        GraphicsContext gc = canvas.getGraphicsContext2D();
        clearCanvas(gc);

        double barWidth = canvas.getWidth() / temperatures.length;
        double maxHeight = canvas.getHeight() * 0.9;

        for (int i = 0; i < temperatures.length; i++) {
            double barHeight = (temperatures[i] / maxTemp) * maxHeight;
            double xPos = i * barWidth;
            double yPos = canvas.getHeight() - barHeight;
            int month = i + 1;
            double temperature = temperatures[i];

            if (temperatures[i] == maxTemp) {
                gc.setFill(Color.RED);  // Hottest month
            } else if (temperatures[i] == minTemp) {
                gc.setFill(Color.BLUE);  // Coolest month
            } else {
                gc.setFill(Color.GRAY);  // Neutral months
            }
            drawBar(gc, xPos, yPos, barWidth, barHeight, canvas.getHeight(), month, temperature);
        }
    }

    // Clear the canvas before drawing the updated chart
    private void clearCanvas(GraphicsContext gc) {
        gc.setFill(Color.WHITE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
    }

    private void drawBar(GraphicsContext gc, double xPos, double yPos, double barWidth, double barHeight, double canvasHeight, int month, double temperature) {
        gc.fillRect(xPos, yPos, barWidth - 5, barHeight);
        gc.setFill(Color.BLACK);
        gc.fillText(String.valueOf(temperature), xPos + barWidth / 2 - 10, canvasHeight - barHeight - 2);
        gc.fillText(String.valueOf(month), xPos + barWidth / 2 - 5, canvasHeight - 5);
    }
}








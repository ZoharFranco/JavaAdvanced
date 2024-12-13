package org.example.temperatures;

import java.time.LocalDate;

public class TemperatureEntry {
    private LocalDate date;
    private double temperature;

    public TemperatureEntry(LocalDate date, double temperature) {
        this.date = date;
        this.temperature = temperature;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
}

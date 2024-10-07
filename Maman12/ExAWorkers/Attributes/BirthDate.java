package Maman12.ExAWorkers.Attributes;

import java.util.Calendar;

public class BirthDate implements Attribute {

    private int year;
    private int month;
    private int day;

    public BirthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public boolean isCurrentMonth() {
        Calendar today = Calendar.getInstance();
        return today.get(Calendar.MONTH) == this.month;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}

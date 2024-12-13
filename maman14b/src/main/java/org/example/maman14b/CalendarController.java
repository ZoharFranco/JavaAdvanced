package org.example.maman14b;

import java.util.Calendar;
import java.util.HashMap;

public class CalendarController {
    private final Calendar currentCalendar;
    private final HashMap<String, String> eventsMap;
    private final CalendarView view;

    public CalendarController(CalendarView view) {
        this.currentCalendar = Calendar.getInstance();
        this.eventsMap = new HashMap<>();
        this.view = view;
    }

    public void displayInitialCalendar() {
        view.displayCalendar(currentCalendar, eventsMap);
    }

    public void changeMonth(int change) {
        currentCalendar.add(Calendar.MONTH, change);
        view.displayCalendar(currentCalendar, eventsMap);
    }

    public void handleDayClick(String day) {
        String dateString = getDateString(Integer.parseInt(day));
        String event = eventsMap.getOrDefault(dateString, "");
        view.showEventDialog(dateString,
                event,
                this::saveEvent);
    }

    public void saveEvent(String date, String event) {
        eventsMap.put(date, event);
        view.displayCalendar(currentCalendar, eventsMap);
    }

    private String getDateString(int day) {
        Calendar cal = (Calendar) currentCalendar.clone();
        cal.set(Calendar.DAY_OF_MONTH, day);
        return new java.text.SimpleDateFormat("MM-dd-yyyy").format(cal.getTime());
    }
}

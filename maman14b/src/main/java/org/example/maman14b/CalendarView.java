package org.example.maman14b;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

public class CalendarView {
    private final Stage stage;

    public CalendarView(Stage stage) {
        this.stage = stage;
    }

    public void displayCalendar(Calendar currentCalendar, HashMap<String, String> eventsMap) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);

        int firstDayOfMonth = currentCalendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = currentCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);


        String monthName = new SimpleDateFormat("MMMM yyyy").format(currentCalendar.getTime());
        Label monthLabel = new Label(monthName);
        grid.add(monthLabel, 2, 0, 3, 1);


        Button prevButton = new Button("<");
        Button nextButton = new Button(">");

        prevButton.setOnAction(e -> ((CalendarController) stage.getUserData()).changeMonth(-1));
        nextButton.setOnAction(e -> ((CalendarController) stage.getUserData()).changeMonth(1));

        grid.add(prevButton, 0, 0);
        grid.add(nextButton, 6, 0);


        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        for (int i = 0; i < daysOfWeek.length; i++) {
            grid.add(new Label(daysOfWeek[i]), i, 1);
        }


        int row = 2;
        int col = firstDayOfMonth - 1;
        for (int day = 1; day <= daysInMonth; day++) {
            Button dayButton = new Button(String.valueOf(day));
            String dateKey = getDateString(currentCalendar, day);


            if (eventsMap.containsKey(dateKey)) {
                dayButton.setStyle("-fx-background-color: black; -fx-border-color: black; -fx-text-fill: white");
            }

            dayButton.setOnAction(e -> {
                CalendarController controller = (CalendarController) stage.getUserData();
                if (controller != null) {
                    controller.handleDayClick(dayButton.getText());
                }
            });

            grid.add(dayButton, col, row);

            col++;
            if (col == 7) {
                col = 0;
                row++;
            }
        }

        VBox layout = new VBox(10, grid);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 400, 400);
        stage.setScene(scene);
        stage.setUserData(stage.getUserData());
    }

    public void showEventDialog(String date, String currentEvent, SaveEventHandler saveHandler) {
        TextArea eventTextArea = new TextArea(currentEvent);
        Button saveButton = new Button("Save");

        saveButton.setOnAction(e -> {
            String eventText = eventTextArea.getText();
            saveHandler.saveEvent(date, eventText);
            ((Stage) saveButton.getScene().getWindow()).close();
        });

        VBox dialogLayout = new VBox(10, new Label("Event for " + date), eventTextArea, saveButton);
        dialogLayout.setAlignment(Pos.CENTER);

        Stage dialogStage = new Stage();
        dialogStage.setScene(new Scene(dialogLayout, 300, 200));
        dialogStage.show();
    }

    @FunctionalInterface
    public interface SaveEventHandler {
        void saveEvent(String date, String event);
    }

    private String getDateString(Calendar calendar, int day) {
        Calendar tempCal = (Calendar) calendar.clone();
        tempCal.set(Calendar.DAY_OF_MONTH, day);
        return new SimpleDateFormat("MM-dd-yyyy").format(tempCal.getTime());
    }
}
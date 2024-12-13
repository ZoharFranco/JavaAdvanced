package org.example.maman14b;

import javafx.application.Application;
import javafx.stage.Stage;

public class CalendarApplication extends Application {
    @Override
    public void start(Stage primaryStage) {
        CalendarView view = new CalendarView(primaryStage);
        CalendarController controller = new CalendarController(view);

        // Associate the controller with the stage
        primaryStage.setUserData(controller);

        primaryStage.setTitle("Calendar App");
        controller.displayInitialCalendar(); // Display the initial calendar
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

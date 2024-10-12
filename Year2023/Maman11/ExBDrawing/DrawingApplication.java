package Year2023.Maman11.ExBDrawing;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DrawingApplication extends Application {

    public static int canvasSize = 400;
    public static int sceneSize = 400;

    @Override
    public void start(Stage primaryStage) {
        // Create a Pane
        Pane root = new Pane();

        // Create a Canvas with width and height
        Canvas canvas = new Canvas(canvasSize, canvasSize);
        root.getChildren().add(canvas);


        // Get the GraphicsContext from the Canvas
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Create a controller to handle drawing
        Controller controller = new Controller(gc);

        Button button = new Button("Rest pixels");

        // Set an action to be performed when the button is clicked
        button.setOnAction(event -> {
            controller.drawPixels();
        });


        // Set up the Scene and Stage
        Scene scene = new Scene(root, sceneSize, sceneSize);
        primaryStage.setTitle("JavaFX Canvas Example");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

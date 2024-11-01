package org.example.maman12b;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOfLifeApp extends Application {
    @Override
    public void start(Stage primaryStage) {

        int gridSize = 20;
        GameOfLifeModel model = new GameOfLifeModel(gridSize);

        int cellSize = 20;
        GameOfLifeView view = new GameOfLifeView(gridSize, cellSize);

        GameOfLifeController controller = new GameOfLifeController(model, view);
        Scene scene = new Scene(controller.getMainLayout());

        primaryStage.setTitle("Game of Life");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
package org.example.maman12b;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class GameOfLifeController {
    private final GameOfLifeModel model;
    private final GameOfLifeView view;
    private VBox mainLayout;

    public GameOfLifeController(GameOfLifeModel model, GameOfLifeView view) {
        this.model = model;
        this.view = view;
        initialize();
    }

    // Initialize the controller
    private void initialize() {

        // Create the grid and add listeners
        addCellClickListeners();
        // Randomize grid at the start
        model.randomizeGrid();
        view.refreshGrid(model.getGrid());

        // Create the "Next Step" button
        Button nextStepButton = new Button("Next Step");
        nextStepButton.setOnAction(_ -> {
            model.updateGrid();
            view.refreshGrid(model.getGrid());
        });

        mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(view.getCellsGridPane(), nextStepButton);
    }

    // Add mouse click listeners to each cell for toggling
    private void addCellClickListeners() {
        for (int row = 0; row < model.getGridSize(); row++) {
            for (int col = 0; col < model.getGridSize(); col++) {
                int finalRow = row;
                int finalCol = col;

                view.getCell(finalRow, finalCol).setOnMouseClicked(_ -> {
                    model.toggleCell(finalRow, finalCol);
                    view.refreshGrid(model.getGrid());
                });
            }
        }
    }

    // Return the main layout containing the grid and the button
    public VBox getMainLayout() {
        return mainLayout;
    }
}

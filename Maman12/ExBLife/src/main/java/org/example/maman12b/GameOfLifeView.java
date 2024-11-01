package org.example.maman12b;

import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class GameOfLifeView {
    private final int cellSize;
    private final int gridSize;
    private final Rectangle[][] cells;

    public GameOfLifeView(int cellSize, int gridSize) {
        this.cellSize = cellSize;
        this.gridSize = gridSize;
        this.cells = new Rectangle[gridSize][gridSize];
        buildCells();
    }

    public void buildCells() {
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                cells[row][col] = new Rectangle(this.cellSize, this.cellSize);
                cells[row][col].setStroke(Color.LIGHTGRAY);
                cells[row][col].setFill(Color.WHITE);
            }
        }
    }

    public void refreshGrid(boolean[][] grid) {
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                cells[row][col].setFill(grid[row][col] ? Color.BLACK : Color.WHITE);
            }
        }
    }

    public Rectangle getCell(int row, int col) {
        return cells[row][col];
    }

    public GridPane getCellsGridPane() {
        GridPane gridPane = new GridPane();
        for (int row = 0; row < gridSize; row++) {
            for (int col = 0; col < gridSize; col++) {
                gridPane.add(cells[row][col], col, row);
            }
        }
        return gridPane;
    }

    public int getCellSize() {
        return cellSize;
    }
}

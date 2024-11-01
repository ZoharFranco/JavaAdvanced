package org.example.maman12b;

import java.util.Random;

public class GameOfLifeModel {
    private final int gridSize;
    private boolean[][] grid;

    public GameOfLifeModel(int gridSize) {
        this.gridSize = gridSize;
        this.grid = new boolean[gridSize][gridSize];
    }


    public void toggleCell(int row, int col) {
        grid[row][col] = !grid[row][col];
    }

    public void randomizeGrid() {
        Random random = new Random();
        for (int row = 0; row < this.gridSize; row++) {
            for (int col = 0; col < this.gridSize; col++) {
                grid[row][col] = random.nextBoolean();
            }
        }
    }

    public void updateGrid() {
        boolean[][] newGrid = new boolean[this.gridSize][this.gridSize];

        for (int row = 0; row < this.gridSize; row++) {
            for (int col = 0; col < this.gridSize; col++) {
                int aliveNeighbors = countAliveNeighbors(row, col);
                boolean alive = grid[row][col];

                if (alive) {
                    newGrid[row][col] = this.isStableAlive(aliveNeighbors);
                } else {
                    newGrid[row][col] = this.isCreationSuitable(aliveNeighbors);
                }
            }
        }

        grid = newGrid;
    }

    private int countAliveNeighbors(int row, int col) {
        int count = 0;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;

                int newRow = row + i;
                int newCol = col + j;

                if (newRow >= 0 && newRow < this.gridSize && newCol >= 0 && newCol < this.gridSize) {
                    if (grid[newRow][newCol]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    private boolean isStableAlive(int aliveNeighbors) {
        return (aliveNeighbors == 2 || aliveNeighbors == 3);
    }

    private boolean isCreationSuitable(int aliveNeighbors) {
        return (aliveNeighbors == 3);
    }

    public int getGridSize() {
        return gridSize;
    }

    public boolean[][] getGrid() {
        return grid;
    }
}

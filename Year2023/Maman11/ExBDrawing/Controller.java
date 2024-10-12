package Year2023.Maman11.ExBDrawing;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Controller {
    private GraphicsContext gc;

    // Constructor to initialize GraphicsContext
    public Controller(GraphicsContext gc) {
        this.gc = gc;
    }

    // Method to draw a rectangle
    public void drawPixels() {
        this.drawPixel(1, 1, Color.BLACK);
    }

    private void drawPixel(int x,
                           int y,
                           Color color) {
        gc.setFill(color);
        gc.fillRect(x, y, 1, 1);
    }
}
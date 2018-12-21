package drawing;

import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;

public class TriangleButtonHandler extends ShapeButtonHandler {
    public TriangleButtonHandler(DrawingPane drawingPane) {
        super(drawingPane);
    }

    @Override
    protected ShapeAdapter createShape() {
        double x = Math.min(originX, destinationX);
        double y = Math.min(originY, destinationY);
        double x3 = (originX + destinationX)/2;
        double y3 = originY;
        Polygon triangle = new Polygon(x3, y3, destinationX, destinationY, x, destinationY);
        triangle.getStyleClass().add("triangle");
        ShapeAdapter t = new ShapeAdapter(triangle);
        return t;
    }
}
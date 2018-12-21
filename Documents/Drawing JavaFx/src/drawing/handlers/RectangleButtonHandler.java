package drawing.handlers;

import drawing.ui.DrawingPane;
import drawing.shapes.IShape;
import drawing.shapes.ShapeAdapter;
import javafx.scene.shape.Rectangle;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class RectangleButtonHandler extends ShapeButtonHandler {

    public RectangleButtonHandler(DrawingPane drawingPane) {
        super(drawingPane);
    }

    @Override
    protected IShape createShape() {
        double x = Math.min(originX, destinationX);
        double y = Math.min(originY, destinationY);
        double width = Math.abs(destinationX - originX);
        double height = Math.abs(destinationY - originY);
        Rectangle rectangle = new Rectangle(x, y, width, height);
        rectangle.getStyleClass().add("rectangle");
        return new ShapeAdapter(rectangle);
    }
}

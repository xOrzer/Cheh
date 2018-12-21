package drawing;

import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class DrawingPane extends Pane implements Iterable<IShape> {

    private MouseMoveHandler mouseMoveHandler;
    private SelectionHandler selectionHandler;

    private ArrayList<IShape> shapes;

    public DrawingPane() {
        clipChildren();
        shapes = new ArrayList<>();
        mouseMoveHandler = new MouseMoveHandler(this);
        selectionHandler = new SelectionHandler();
    }


    /**
     * Clips the children of this {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     */
    void clipChildren() {
        final Rectangle outputClip = new Rectangle();
        this.setClip(outputClip);

        this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
        shape.addShapeToPane(this);
    }


    public Iterator<IShape> iterator() {
        return shapes.iterator();
    }

    /*
    public ArrayList<Shape> getShapes() {
        return shapes;
    }*/

    public void clear() {
        this.getChildren().removeAll(shapes);
        shapes.clear();
    }
}

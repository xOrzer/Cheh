package drawing;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;

    private ArrayList<IShape> selectedShape;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.setOnMousePressed(this);
        drawingPane.setOnMouseDragged(this);
        drawingPane.setOnMouseReleased(this);
    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) { //A MODIFIER ICI TOUCHE MAJ KEYEVENT
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();


            for (IShape shape : drawingPane) {
                if (shape.isOn(event.getX(), event.getY())) {
                    selectedShape = shape;
                    break;
                }
            }

            selectedShape.offset(event.getX(),event.getY());

        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
            if (selectedShape == null)
                return;

            double offsetX = event.getSceneX() - orgSceneX;
            double offsetY = event.getSceneY() - orgSceneY;
            //double newTranslateX = orgTranslateX + offsetX;
            //double newTranslateY = orgTranslateY + offsetY;

            selectedShape.offset(event.getX(),event.getY());
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            selectedShape = null;
        }
    }
}

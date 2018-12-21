package drawing.handlers;

import drawing.ui.DrawingPane;
import drawing.shapes.IShape;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class MouseMoveHandler implements EventHandler<MouseEvent> {

    private DrawingPane drawingPane;

    private double orgSceneX;
    private double orgSceneY;
    private double orgTranslateX;
    private double orgTranslateY;

    private List<IShape> selectedShape;

    public MouseMoveHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        drawingPane.setOnMousePressed(this);
        drawingPane.setOnMouseDragged(this);
        drawingPane.setOnMouseReleased(this);
        this.selectedShape = new ArrayList<>();
    }

    @Override
    public void handle(MouseEvent event) {

        if (event.getEventType().equals(MouseEvent.MOUSE_PRESSED)) {
            orgSceneX = event.getSceneX();
            orgSceneY = event.getSceneY();
            selectedShape = drawingPane.getSelection();

        }

        if (event.getEventType().equals(MouseEvent.MOUSE_DRAGGED)) {
            if (selectedShape.size() > 0) {

                double offsetX = event.getSceneX() - orgSceneX;
                double offsetY = event.getSceneY() - orgSceneY;

                for(IShape shape : selectedShape)
                    shape.offset(offsetX, offsetY);

                orgSceneX += offsetX;
                orgSceneY += offsetY;
            }
        }

        if (event.getEventType().equals(MouseEvent.MOUSE_RELEASED)) {
            selectedShape = new ArrayList<>();
        }
    }
}

package drawing.handlers;

import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class UndoButtonHandler implements EventHandler<ActionEvent> {

    private DrawingPane drawingPane;

    public UndoButtonHandler(DrawingPane dpane) {
        drawingPane = dpane;
    }

    @Override
    public void handle(ActionEvent arg)
    {
        drawingPane.getHistory().undo();
    }
}

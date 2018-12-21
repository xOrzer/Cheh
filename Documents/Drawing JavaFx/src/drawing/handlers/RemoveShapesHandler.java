package drawing.handlers;

import drawing.ui.DrawingPane;
import drawing.commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RemoveShapesHandler implements EventHandler<ActionEvent> {
    private DrawingPane drawingPane;



    private ICommand remove;

    public RemoveShapesHandler(ICommand c, DrawingPane dpane)
    {
        remove = c;
        drawingPane = dpane;
    }

    @Override
    public void handle(ActionEvent arg)
    {
        drawingPane.getHistory().exec(remove);
    }
}

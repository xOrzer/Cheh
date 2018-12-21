package drawing.handlers;

import drawing.ui.DrawingPane;
import drawing.commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ClearButtonHandler implements EventHandler<ActionEvent> {

    private ICommand clear;
    private DrawingPane drawingPane;

    public ClearButtonHandler(ICommand c, DrawingPane dpane)
    {
        clear = c;
        drawingPane = dpane;
    }

    @Override
    public void handle(ActionEvent arg)
    {
        drawingPane.getHistory().exec(clear);
    }

}
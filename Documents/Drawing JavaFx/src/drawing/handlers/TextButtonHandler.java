package drawing.handlers;

import drawing.ui.DrawingPane;
import drawing.commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class TextButtonHandler implements EventHandler<ActionEvent> {

    private ICommand text;
    private DrawingPane drawingPane;

    public TextButtonHandler(ICommand t, DrawingPane dpane)
    {
        text = t;
        drawingPane = dpane;
    }

    @Override
    public void handle(ActionEvent arg)
    {
        drawingPane.getHistory().exec(text);
    }
}

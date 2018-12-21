package drawing.handlers;

import drawing.ui.DrawingPane;
import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class CloneButtonHandler implements EventHandler<ActionEvent> {

    private CommandHistory history = new CommandHistory();
    private DrawingPane drawingPane;
    private ICommand clone;

    public CloneButtonHandler(ICommand c, DrawingPane dpane) {

        clone = c ;
        drawingPane = dpane;
    }

    @Override
    public void handle(ActionEvent arg)
    {

        drawingPane.getHistory().exec(clone);

    }
}

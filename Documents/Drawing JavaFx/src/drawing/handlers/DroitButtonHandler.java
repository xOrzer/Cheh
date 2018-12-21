package drawing.handlers;

import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import drawing.ui.DrawingPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DroitButtonHandler implements EventHandler<ActionEvent> {

    private CommandHistory history = new CommandHistory();
    private DrawingPane drawingPane;
    private ICommand bind;

    public DroitButtonHandler(ICommand c, DrawingPane dpane) {

        bind = c ;
        drawingPane = dpane;
    }

    @Override
    public void handle(ActionEvent arg)
    {
        drawingPane.getHistory().exec(bind);
    }

}

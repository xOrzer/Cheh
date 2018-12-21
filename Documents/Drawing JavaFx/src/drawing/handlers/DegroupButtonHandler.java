package drawing.handlers;

import drawing.ui.DrawingPane;
import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class DegroupButtonHandler implements EventHandler<ActionEvent> {

    private CommandHistory history = new CommandHistory();
    private ICommand degroup;
    private DrawingPane drawingPane;



    public DegroupButtonHandler(ICommand c, DrawingPane dpane)
    {
        degroup = c;
        drawingPane = dpane;
    }


    @Override
    public void handle(ActionEvent event) {

        drawingPane.getHistory().exec(degroup);
    }
}


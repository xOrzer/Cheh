package drawing.handlers;

import drawing.ui.DrawingPane;
import drawing.commands.CommandHistory;
import drawing.commands.ICommand;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class GroupButtonHandler implements EventHandler<ActionEvent> {

    private CommandHistory history = new CommandHistory();
    private ICommand group;
    private DrawingPane drawingPane;


    public GroupButtonHandler(ICommand c, DrawingPane dpane)
    {
        group = c;
        drawingPane = dpane;
    }


    @Override
    public void handle(ActionEvent event) {
        drawingPane.getHistory().exec(group);

    }
}

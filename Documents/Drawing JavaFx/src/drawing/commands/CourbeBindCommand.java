package drawing.commands;

import drawing.Arthur;
import drawing.shapes.*;
import drawing.ui.DrawingPane;

public class CourbeBindCommand implements ICommand {
    private DrawingPane drawingPane;

    public CourbeBindCommand(DrawingPane dpane){
        drawingPane = dpane;
    }

    @Override
    public void execute() throws Arthur {

        if (drawingPane.getSelection().size() != 2) {
            drawingPane.setError("Il faut 2 figures !");
            throw new Arthur("Il faut 2 figures !");
        }

        Courbe d = new Courbe();
        IShape Line = new Edge(drawingPane.getSelection().get(0), drawingPane.getSelection().get(1), d);
        drawingPane.addShape(Line);

    }

    @Override
    public void undo() {

    }

    @Override
    public ICommand clone() {
        return null;
    }
}

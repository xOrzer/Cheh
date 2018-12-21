package drawing.commands;

import drawing.Arthur;
import drawing.shapes.Droit;
import drawing.shapes.Edge;
import drawing.shapes.IShape;
import drawing.ui.DrawingPane;
import javafx.scene.shape.Path;

public class DroitBindCommand implements ICommand {

    private DrawingPane drawingPane;

    public DroitBindCommand(DrawingPane dpane){
        drawingPane = dpane;
    }

    @Override
    public void execute() throws Arthur {
        if(drawingPane.getSelection().size() != 2){
            drawingPane.setError("OMG WTF FO 2 PHIGURS");
            throw new Arthur("OMG WTF FO 2 PHIGURS");
        }

        Droit d = new Droit();
        IShape Line = new Edge(drawingPane.getSelection().get(0),drawingPane.getSelection().get(1), d);
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

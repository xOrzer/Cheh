package drawing.commands;

import drawing.Arthur;
import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

public class CloneCommand implements ICommand {
    private DrawingPane drawingPane;
    private IShape ishape;

    public CloneCommand(DrawingPane dpane){
        drawingPane = dpane;
    }

    @Override
    public void execute() throws Arthur{
        if(drawingPane.getSelection().size() == 0){
            drawingPane.setError("Faut sélectionner des trucs pour cloner !");
            throw new Arthur("Faut sélectionner des trucs pour cloner !");
        }
        for (int i = 0; i < drawingPane.getSelection().size(); i++) {
            drawingPane.addShape(drawingPane.getSelection().get(i).clone());
        }
    }

    @Override
    public void undo() {
        drawingPane.removeShape(ishape);
    }

    @Override
    public ICommand clone() {
        ICommand copy = new CloneCommand(drawingPane);
        ((CloneCommand) copy).ishape = this.ishape;
        return copy;
    }
}

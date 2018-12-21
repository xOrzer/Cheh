package drawing.commands;

import drawing.Arthur;
import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

import java.util.ArrayList;

public class RemoveCommand implements ICommand {
    private DrawingPane drawingPane;
    private ArrayList<IShape> savedShapes;


    public RemoveCommand(DrawingPane dpane){
        drawingPane = dpane;
        savedShapes = new ArrayList<IShape>();

    }

    @Override
    public void execute() throws Arthur {

        if(drawingPane.getSelection().size() <= 0){
            drawingPane.setError("Il faut selectionner une ou plusieurs forme pour suppr.");
            throw new Arthur("Il faut selectionner une ou plusieurs forme pour suppr.");
        }

        savedShapes.clear();
        savedShapes.addAll(drawingPane.getSelection());
        drawingPane.removeSelection();
    }

    @Override
    public void undo() {
        for (int j = 0; j <  savedShapes.size(); j++) {
            drawingPane.addShape(savedShapes.get(j));
        }
    }

    @Override
    public ICommand clone(){
        ICommand copy = new RemoveCommand(drawingPane);
        ((RemoveCommand) copy).savedShapes.addAll(this.savedShapes);
        return copy;
    }


}

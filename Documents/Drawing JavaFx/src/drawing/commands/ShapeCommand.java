package drawing.commands;

import drawing.ui.DrawingPane;
import drawing.shapes.IShape;

public class ShapeCommand implements ICommand {

    private DrawingPane drawingPane;
    private IShape ishape;

    public ShapeCommand(DrawingPane dpane, IShape shape){
        drawingPane = dpane;
        ishape = shape;
    }

    @Override
    public void execute() {
        drawingPane.addShape(ishape);
    }

    @Override
    public void undo() {
        drawingPane.removeShape(ishape);
    }

    @Override
    public ICommand clone(){
        ICommand copy = new ShapeCommand(drawingPane, ishape);
        ((ShapeCommand) copy).ishape = this.ishape;
        return copy;
    }
}

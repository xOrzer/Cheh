package drawing.handlers;
import java.util.ArrayList;
import java.util.List;

import drawing.ui.DrawingPane;
import drawing.shapes.IShape;
import drawing.Observable;
import drawing.Observer;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class SelectHandler implements EventHandler<MouseEvent>, Observable {

    private DrawingPane drawingPane;

    private List<IShape> selectedShapes;
    private List<Observer> observers;

    public SelectHandler(DrawingPane drawingPane) {
        this.drawingPane = drawingPane;
        this.drawingPane.addEventFilter(MouseEvent.MOUSE_PRESSED,this);
        selectedShapes = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    @Override
    public void handle(MouseEvent event) {
        if(event.isShiftDown())
        {
            for(IShape shape : drawingPane)
            {
                if(shape.isOn(event.getX(), event.getY()))
                {
                    addOrRemoveSelectedShape(shape);
                    break;
                }
            }
        }
        else
        {
            for(IShape shape : drawingPane)
            {
                removeShape(shape);
                if(shape.isOn(event.getX(), event.getY()))
                    addOrRemoveSelectedShape(shape);
            }
        }
        notifyObservers();
    }

    private void addOrRemoveSelectedShape(IShape shape)
    {
        if(selectedShapes.contains(shape))
        {
            removeShape(shape);
        }
        else
        {
            addShape(shape);
        }
    }

    private void addShape(IShape shape)
    {
        selectedShapes.add(shape);
        shape.setSelected(true);
    }

    private void removeShape(IShape shape)
    {
        selectedShapes.remove(shape);
        shape.setSelected(false);
    }

    public void clearSelection(){
        selectedShapes.clear();

    }

    public List<IShape> getShapes()
    {
        return selectedShapes;
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers){
            o.update();
        }
    }
}

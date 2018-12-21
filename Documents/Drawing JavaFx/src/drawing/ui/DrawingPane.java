package drawing.ui;

import drawing.shapes.IShape;
import drawing.Observable;
import drawing.Observer;
import drawing.commands.CommandHistory;
import drawing.handlers.MouseMoveHandler;
import drawing.handlers.SelectHandler;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class DrawingPane extends Pane implements Iterable<IShape>, Observable {

    private CommandHistory history = new CommandHistory();
    private MouseMoveHandler mouseMoveHandler;
    private SelectHandler selectHandler;
    private ArrayList<IShape> shapes;
    private Collection<Observer> observers = new ArrayList<>();
    private int state = 0;
    private int numberShape;
    private String exception;

    public CommandHistory getHistory() {
        return history;
    }

    public ArrayList<IShape> getShapes() {
        return shapes;
    }

    public DrawingPane() {
        clipChildren();
        shapes = new ArrayList<>();
        mouseMoveHandler = new MouseMoveHandler(this);
        selectHandler = new SelectHandler(this);
    }
    /**
     * Clips the children of this {@link Region} to its current size.
     * This requires attaching a change listener to the region’s layout bounds,
     * as JavaFX does not currently provide any built-in way to clip children.
     */
    void clipChildren() {
        final Rectangle outputClip = new Rectangle();
        this.setClip(outputClip);

        this.layoutBoundsProperty().addListener((ov, oldValue, newValue) -> {
            outputClip.setWidth(newValue.getWidth());
            outputClip.setHeight(newValue.getHeight());
        });
    }


    public List<IShape> getSelection()
    {
        return selectHandler.getShapes();
    }

    public void addShape(IShape shape) {
        shapes.add(shape);
        shape.addShapeToPane(this);
        this.notifyObservers();
    }

    public void removeShape(IShape shape) {
        shapes.remove(shape);
        shape.removeShapeFromPane(this);
        this.notifyObservers();
    }

    @Override
    public Iterator<IShape> iterator() {
        return shapes.iterator();
    }

    public void clear() {
        for (IShape shape : shapes){
            shape.removeShapeFromPane(this);
        }

        getSelection().clear();
        shapes.clear();
    }

    public void removeSelection(){
        for(IShape shape : this.getSelection()){
            shape.removeShapeFromPane(this);
            shapes.remove(shape);
        }
        this.getSelection().clear();
        notifyObservers();
    }

    public int getNumberShape() {
        return this.shapes.size();
    }

    public void addObserver (Observer o) {
        observers.add (o);
        selectHandler.addObserver(o);
    }

    public void removeObserver (Observer o) {
        observers.remove (o);
        selectHandler.removeObserver(o);
    }

    public void notifyObservers (){
        for(Observer obs : observers)
            obs.update ();
    }

    public String getError(){
        return this.exception;
    }

    public void setError(String s){
        this.exception = s;
    }
}

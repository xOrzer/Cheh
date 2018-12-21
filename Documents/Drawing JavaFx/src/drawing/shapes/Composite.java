package drawing.shapes;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Composite implements IShape {

    private ArrayList<IShape> shapeList = new ArrayList<IShape>();
    private boolean isSelected;


    public ArrayList<IShape> getList(){
        return this.shapeList;
    }

    public void add(IShape shape){
        shapeList.add(shape);
    }

    public void remove(IShape shape){
        shapeList.remove(shape);
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.isSelected = selected;
        for (int i = 0; i < shapeList.size(); i++) {
            shapeList.get(i).setSelected(selected);
        }
    }

    @Override
    public boolean isOn(double x, double y) {
        for (int i = 0; i < shapeList.size(); i++) {
            if(shapeList.get(i).isOn(x,y))
                return true;
        }
        return false;
    }

    @Override
    public void offset(double x, double y) {
        for (int i = 0; i < shapeList.size(); i++) {
            shapeList.get(i).offset(x,y);
        }
    }

    @Override
    public void addShapeToPane(Pane pane) {
        for (int i = 0; i < shapeList.size(); i++) {
            shapeList.get(i).addShapeToPane(pane);
        }
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        for (int i = 0; i < shapeList.size(); i++) {
            shapeList.get(i).removeShapeFromPane(pane);
        }
    }

    @Override
    public IShape clone() {
        IShape copy = new Composite();
        ((Composite) copy).shapeList.addAll(this.shapeList);
        copy.offset(5,5);
        return copy;
    }

    @Override
    public Bounds getBoundsInParent() {
        return null;
    }


    @Override
    public ObservableValue translateXProperty() {
        return null;
    }

    @Override
    public ObservableValue translateYProperty() {
        return null;
    }

}

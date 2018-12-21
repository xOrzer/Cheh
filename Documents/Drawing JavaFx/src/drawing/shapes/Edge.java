package drawing.shapes;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;

import java.awt.*;

public class Edge implements IShape {
    IShape from;
    IShape to;
    Path shape;
    IEdgeStrategy strat;

    private boolean isSelected;

    public Edge(IShape f, IShape t, IEdgeStrategy s){
        shape = new Path();
        from = f;
        to = t;
        strat = s;

        s.buildPath(f,t,shape);

    }

    public void setEdgeStrategy(IEdgeStrategy s){
        strat = s;
        s.buildPath(this.from,this.to,this.shape);
    }

    @Override
    public boolean isSelected() {
        return this.isSelected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.isSelected = selected;
        if (selected)
            shape.getStyleClass().add("selected");
        else
            shape.getStyleClass().remove("selected");
    }

    @Override
    public boolean isOn(double x, double y) {
        return shape.getBoundsInParent().contains(x, y);
    }

    @Override
    public void offset(double x, double y) {

    }

    @Override
    public void addShapeToPane(Pane pane) {
        pane.getChildren().add(shape);
        shape.toBack();
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        pane.getChildren().remove(shape);
    }

    @Override
    public IShape clone() {
        return null;
    }

    @Override
    public Bounds getBoundsInParent() {
        return null;
    }

    @Override
    public ObservableValue translateXProperty() {
        return shape.translateXProperty();
    }

    @Override
    public ObservableValue translateYProperty() {
        return shape.translateYProperty();
    }
}

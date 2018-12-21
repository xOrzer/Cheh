package drawing.shapes;

import javafx.beans.value.ObservableValue;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;

public class Decorator implements IShape {

    private IShape ishape;
    private Text text;

    public Decorator (IShape shape) {
        this.ishape = shape;
        this.text = new Text("Minh !");
        this.text.translateXProperty().bind(ishape.translateXProperty());
        this.text.translateYProperty().bind(ishape.translateYProperty());


        //this.text.setX(this.ishape.getBoundsInParent().getMinX()+this.getBoundsInParent().getWidth()/2);
        //this.text.setY(this.ishape.getBoundsInParent().getMinY()+this.getBoundsInParent().getHeight()/2);
    }

    @Override
    public boolean isSelected() {
        return this.ishape.isSelected();
    }

    @Override
    public void setSelected(boolean selected) {
        this.ishape.setSelected(selected);
    }

    @Override
    public boolean isOn(double x, double y) {
        return this.ishape.isOn(x,y);
    }

    @Override
    public void offset(double x, double y) {
        this.ishape.offset(x,y);
        //this.text.setX(this.text.getX()+x);
        //this.text.setY(this.text.getY()+y);
    }

    @Override
    public void addShapeToPane(Pane dp) {
        this.ishape.addShapeToPane(dp);
        dp.getChildren().add(this.text);
    }

    @Override
    public void removeShapeFromPane(Pane pane) {
        this.ishape.removeShapeFromPane(pane);
        pane.getChildren().remove(text);
    }

    @Override
    public IShape clone() {
        Decorator copy = new Decorator(this.ishape.clone());
        return copy;

    }

    @Override
    public Bounds getBoundsInParent() {
        return ishape.getBoundsInParent();
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

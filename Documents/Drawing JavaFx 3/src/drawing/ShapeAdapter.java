package drawing;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Shape;

public class ShapeAdapter implements IShape{
    private Shape shape;

    public ShapeAdapter(Shape s){
        this.shape = s;
    }

    @Override
    public boolean isSelected() {
        return false;
    }

    @Override
    public void setSelected(boolean selected) {
        if(selected) {
            shape.getStyleClass().add("selected");
        }

    }

    @Override
    public boolean isOn(double x, double y) {

        if(shape.getBoundsInParent().contains(x,y)){

            return true;
        }
        return false;
    }

    @Override
    public void offset(double x, double y) {
        shape.setTranslateX(x);
        shape.setTranslateY(y);
    }

    @Override
    public void addShapeToPane(Pane pane) {
        pane.getChildren().add(this.shape);
    }

    @Override
    public void removeShapeFromPane(Pane pane) {

    }
}

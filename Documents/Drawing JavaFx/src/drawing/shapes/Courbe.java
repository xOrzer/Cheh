package drawing.shapes;

import javafx.scene.shape.ArcTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Courbe implements IEdgeStrategy {


    public Courbe(){ }

    @Override
    public void buildPath(IShape f, IShape t, Path p) {
        MoveTo moveTo = new MoveTo();
        ArcTo arcTo = new ArcTo();


        moveTo.xProperty().bind(f.translateXProperty());
        moveTo.yProperty().bind(f.translateYProperty());
        arcTo.xProperty().bind(t.translateXProperty());
        arcTo.yProperty().bind(t.translateYProperty());
        arcTo.setRadiusX(60);
        arcTo.setRadiusY(60);


        p.getElements().add(moveTo);
        p.getElements().add(arcTo);
    }


}

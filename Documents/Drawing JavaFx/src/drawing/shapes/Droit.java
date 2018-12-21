package drawing.shapes;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Droit implements IEdgeStrategy {


    public Droit(){ }

    @Override
    public void buildPath(IShape f, IShape t, Path p) {
        MoveTo moveTo = new MoveTo();
        LineTo lineTo = new LineTo();


        moveTo.xProperty().bind(f.translateXProperty());
        moveTo.yProperty().bind(f.translateYProperty());
        lineTo.xProperty().bind(t.translateXProperty());
        lineTo.yProperty().bind(t.translateYProperty());

        p.getElements().add(moveTo);
        p.getElements().add(lineTo);
    }


}

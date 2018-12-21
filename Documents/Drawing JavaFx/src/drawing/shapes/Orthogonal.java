package drawing.shapes;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurveTo;

public class Orthogonal implements IEdgeStrategy {
    public Orthogonal(){ }

    @Override
    public void buildPath(IShape f, IShape t, Path p) {
        MoveTo moveTo = new MoveTo();
        QuadCurveTo quadCurveTo = new QuadCurveTo();


        moveTo.xProperty().bind(f.translateXProperty());
        moveTo.yProperty().bind(f.translateYProperty());
        quadCurveTo.xProperty().bind(t.translateXProperty());
        quadCurveTo.yProperty().bind(t.translateYProperty());
        quadCurveTo.setControlX(1000.0f);
        quadCurveTo.setControlY(5.0f);

        p.getElements().add(moveTo);
        p.getElements().add(quadCurveTo);
    }


}

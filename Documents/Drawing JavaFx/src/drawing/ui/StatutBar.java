package drawing.ui;

import drawing.shapes.IShape;
import drawing.Observer;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;


public class StatutBar extends HBox implements Observer {
    private Label labelForm;
    private Label labelForm2;
    private DrawingPane dp;
    private List<IShape>sp;

    public StatutBar(DrawingPane drawingPane) {
        this.dp = drawingPane;
        this.sp = drawingPane.getSelection();

        this.labelForm = new Label("0 shapes(s) | ");
        this.getChildren().addAll(this.labelForm);

        this.labelForm2 = new Label("0 shapes(s) selected");
        this.getChildren().addAll(this.labelForm2);
    }

    public void update () {
        this.labelForm.setText(this.dp.getNumberShape() + " shape(s) | ");
        this.labelForm2.setText(this.sp.size() + " shape(s) selected");
    }
}

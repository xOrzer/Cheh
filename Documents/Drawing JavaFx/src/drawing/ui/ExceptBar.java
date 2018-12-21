package drawing.ui;

import drawing.Observer;
import drawing.shapes.IShape;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.List;

public class ExceptBar extends HBox implements Observer {

        private Label labelForm;
        private DrawingPane dp;

        public ExceptBar(DrawingPane drawingPane) {
            this.dp = drawingPane;

            this.labelForm = new Label("Exception : 0");
            this.getChildren().addAll(this.labelForm);

        }

        public void update () {
            this.labelForm.setText("Exception : "+ this.dp.getError());
            this.dp.setError("0");
        }

}

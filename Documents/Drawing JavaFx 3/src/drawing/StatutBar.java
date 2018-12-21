package drawing;

import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class StatutBar extends HBox {

    public Label label = new Label();
    public int nbShapes;

    public StatutBar(){
        nbShapes = 0;
    }
}

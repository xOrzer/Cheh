package drawing.ui;

import drawing.Observer;
import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class BarBottom extends VBox implements Observer {
    public ExceptBar exceptBar;
    public StatutBar statutBar;



    public BarBottom(DrawingPane drawingPane){

        exceptBar = new ExceptBar(drawingPane);
        statutBar = new StatutBar(drawingPane);

        this.statutBar.setPadding(new Insets(7));
        this.statutBar.getStyleClass().add("statutbar");

        this.exceptBar.getStyleClass().add("statutbar");
        this.exceptBar.setPadding(new Insets(7));

        getChildren().addAll(exceptBar, statutBar);

    }

    @Override
    public void update() {
        statutBar.update();
        exceptBar.update();
    }



}

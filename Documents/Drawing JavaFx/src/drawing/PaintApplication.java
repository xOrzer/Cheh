package drawing;

import drawing.ui.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by lewandowski on 20/12/2017.
 */
public class PaintApplication extends Application {

    public static final int WIDTH = 1200;
    public static final int HEIGHT = 1000;

    private Scene scene;
    private BorderPane root;
    private DrawingPane drawingPane;
    private ToolBar toolBar;
    private BarBottom bb;




    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new BorderPane();
        scene = new Scene(root, WIDTH, HEIGHT);

        root.getStylesheets().add(PaintApplication.class.getResource("./CSS/Paint.css").toExternalForm());

        drawingPane = new DrawingPane();
        drawingPane.getStyleClass().add("drawingPane");
        root.setCenter(drawingPane);

        this.bb = new BarBottom(drawingPane);
        this.toolBar = new ToolBar(drawingPane);

        drawingPane.addObserver(bb);

        root.setTop(toolBar);
        root.setBottom(bb);


        primaryStage.setTitle("Drawing");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public DrawingPane getDrawingPane() {
        return drawingPane;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

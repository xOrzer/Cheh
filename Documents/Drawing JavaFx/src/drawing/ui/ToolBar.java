package drawing.ui;

import drawing.Observer;
import drawing.commands.*;
import drawing.handlers.*;
import drawing.shapes.Courbe;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class ToolBar extends HBox implements Observer {

    private Button clearButton;
    private Button rectangleButton;
    private Button circleButton;
    private Button triangleButton;
    private Button removeButton;
    private Button groupButton;
    private Button degroupButton;
    private Button undoButton;
    private Button cloneButton;
    private Button textButton;
    private Button bindButton;
    private Button courbeButton;
    private Button orthoButton;

    public ToolBar(DrawingPane drawingPane) {

        ClearCommand clear = new ClearCommand(drawingPane);
        DegroupCommand degroup = new DegroupCommand(drawingPane);
        GroupCommand group = new GroupCommand(drawingPane);
        RemoveCommand remove = new RemoveCommand(drawingPane);
        CloneCommand clone = new CloneCommand(drawingPane);
        TextCommand text = new TextCommand(drawingPane);
        DroitBindCommand droit = new DroitBindCommand(drawingPane);
        CourbeBindCommand courbe = new CourbeBindCommand(drawingPane);
        OrthoBindCommand ortho = new OrthoBindCommand(drawingPane);

        clearButton = new Button("Clear");
        // clearButton.setOnAction(event -> drawingPane.clear());
        clearButton.addEventFilter(ActionEvent.ACTION, new ClearButtonHandler(clear, drawingPane));

        Image squareImage = new Image(getClass().getResourceAsStream("square.png"));
        rectangleButton = new Button("Rectangle", new ImageView(squareImage));
        rectangleButton.addEventFilter(ActionEvent.ACTION, new RectangleButtonHandler(drawingPane));

        Image circleImage = new Image(getClass().getResourceAsStream("circle.png"));
        circleButton = new Button("Circle", new ImageView(circleImage));
        circleButton.addEventFilter(ActionEvent.ACTION, new EllipseButtonHandler(drawingPane));

        Image triangleImage = new Image(getClass().getResourceAsStream("triangle.png"));
        triangleButton = new Button("Triangle", new ImageView(triangleImage));
        triangleButton.addEventFilter(ActionEvent.ACTION, new TriangleButtonHandler(drawingPane));

        Image removeImage = new Image(getClass().getResourceAsStream("delete.png"));
        removeButton = new Button("Suppr.", new ImageView(removeImage));
        removeButton.addEventFilter(ActionEvent.ACTION, new RemoveShapesHandler(remove, drawingPane));

        groupButton = new Button("Group");
        groupButton.addEventFilter(ActionEvent.ACTION, new GroupButtonHandler(group, drawingPane));
        degroupButton = new Button("Degroup");
        degroupButton.addEventFilter(ActionEvent.ACTION, new DegroupButtonHandler(degroup, drawingPane));
        undoButton = new Button("Undo");
        undoButton.addEventFilter(ActionEvent.ACTION, new UndoButtonHandler(drawingPane));
        cloneButton = new Button("Clone");
        cloneButton.addEventFilter(ActionEvent.ACTION, new CloneButtonHandler(clone, drawingPane));
        textButton = new Button("Text");
        textButton.addEventFilter(ActionEvent.ACTION, new TextButtonHandler(text, drawingPane));
        bindButton = new Button("Droit");
        bindButton.addEventFilter(ActionEvent.ACTION, new DroitButtonHandler(droit, drawingPane));
        courbeButton = new Button("Courbe");
        courbeButton.addEventFilter(ActionEvent.ACTION, new DroitButtonHandler(courbe, drawingPane));
        orthoButton = new Button("Ortho");
        orthoButton.addEventFilter(ActionEvent.ACTION, new DroitButtonHandler(ortho, drawingPane));
        getChildren().addAll(clearButton, rectangleButton, circleButton, triangleButton, removeButton, groupButton, degroupButton, undoButton, cloneButton, textButton, bindButton, courbeButton, orthoButton);
        setPadding(new Insets(5));
        setSpacing(5.0);
        getStyleClass().add("toolbar");
    }

    public void update () {

    }
}

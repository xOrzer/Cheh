package lsg;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lsg.graphics.CSSFactory;
import lsg.graphics.ImageFactory;
import lsg.graphics.panes.AnimationPane;
import lsg.graphics.panes.CreationPane;
import lsg.graphics.panes.TitlePane;

public class LearningSoulsGameApplication extends Application{

    public static final String TITLE = "Learning Souls Game" ;

    public static final double DEFAULT_SCENE_WIDTH = 1200 ;
    public static final double DEFAULT_SCENE_HEIGHT = 800 ;

    private Scene scene ;
    private AnchorPane root;

    private TitlePane gameTitle ;
    private CreationPane creationPane ;
    private AnimationPane animationPane ;

    private String heroName ;

    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle(TITLE);
        root = new AnchorPane() ;
        scene = new Scene(root, DEFAULT_SCENE_WIDTH, DEFAULT_SCENE_HEIGHT);

        stage.setResizable(false);
        stage.setScene(scene);
        buildUI() ;
        addListeners() ;

        stage.show();

        startGame() ;
    }

    private void addListeners(){
        creationPane.getNameField().setOnAction((event -> {
            heroName = creationPane.getNameField().getText() ;
            System.out.println("Nom du héro : " + heroName);
            if(!heroName.isEmpty()){
                root.getChildren().remove(creationPane);
                gameTitle.zoomOut((event1 -> play()));
            }
        }));
    }

    private void startGame(){
        gameTitle.zoomIn((event -> {
            creationPane.fadeIn((event1 -> {
                ImageFactory.preloadAll((() -> {
                    System.out.println("Pré-chargement des images terminé") ;
                })) ;
            }));
        }));
    }

    private void play(){
        root.getChildren().add(animationPane) ;
        animationPane.startDemo();
    }


    private void buildUI(){
        scene.getStylesheets().add(CSSFactory.getStyleSheet("LSG.css")) ;

        gameTitle = new TitlePane(scene, LearningSoulsGameApplication.TITLE) ;
        AnchorPane.setTopAnchor(gameTitle, 0.0);
        AnchorPane.setLeftAnchor(gameTitle, 0.0);
        AnchorPane.setRightAnchor(gameTitle, 0.0);
        root.getChildren().addAll(gameTitle) ;

        creationPane = new CreationPane() ;
        creationPane.setOpacity(0);
        AnchorPane.setTopAnchor(creationPane, 0.0);
        AnchorPane.setLeftAnchor(creationPane, 0.0);
        AnchorPane.setRightAnchor(creationPane, 0.0);
        AnchorPane.setBottomAnchor(creationPane, 0.0);
        root.getChildren().addAll(creationPane) ;

        animationPane = new AnimationPane(root) ;

    }


}

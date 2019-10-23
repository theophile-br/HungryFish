package View;

import Controller.ControllerInGame;
import Controller.ControllerMenuPrincipal;
import Controller.ControllerMenuOption;
import Model.ModelInGame;
import Model.ModelMenuOption;
import Model.ModelMenuPrincipal;
import Tool.Path;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewHandler extends Application {
    private Stage primaryStage;
    private ViewMenuPrincipal vmp;
    private ViewInGame vig;
    private ViewMenuOption vmo;
    private ModelMenuPrincipal mmp;
    private ModelInGame mig;
    private ModelMenuOption mmo;
    private ControllerMenuPrincipal cmp;
    private ControllerInGame cig;
    private ControllerMenuOption cmo;
    private Group root;
    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = new Group();
        scene = new Scene(root);

        this.primaryStage = primaryStage;

        launchViewMenuPrincipal();

        primaryStage.setTitle("HungryFish");
        root.getStylesheets().add(Path.urlStyleshet);
        //primaryStage.setFullScreenExitHint("");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false);
        //primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setFullScreen(true);
        primaryStage.show();

    }

    public void setEventHandlerMenu(ControllerMenuPrincipal cm) {
        vmp.setEvents(cm);
    }

    public void setEventHandlerInGame(ControllerInGame cig){
        vig.setEvents(cig);}

    public void setEventHandlerMenuOption(ControllerMenuOption cmo){ vmo.setEvents(cmo);}

    public ViewMenuPrincipal getVmp() {
        return vmp;
    }

    public ViewMenuOption getVmo() {
        return vmo;
    }

    public ViewInGame getVig(){return vig;}

    public void setVig(ViewInGame vig){this.vig =vig;}

    public Stage getPrimaryStage(){
        return primaryStage;
    }

    public void launchViewInGame(){
        mig = new ModelInGame();
        vig = new ViewInGame(root);
        cig = new ControllerInGame(this, mig);
    }

    public void launcViewMenuOption(){
        mmo = new ModelMenuOption();
        vmo = new ViewMenuOption(root);
        cmo = new ControllerMenuOption(this,mmo);
    }

    public void launchViewMenuPrincipal(){
        mmp = new ModelMenuPrincipal();
        vmp = new ViewMenuPrincipal(root, mmp);
        cmp = new ControllerMenuPrincipal(this, mmp);
    }
}

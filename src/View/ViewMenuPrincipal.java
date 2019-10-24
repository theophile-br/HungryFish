package View;

import Controller.ControllerMenuPrincipal;
import Model.ModelMenuPrincipal;
import Tool.Path;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Screen;


public class ViewMenuPrincipal {

    // TODO Rajouter des variable si besoin //
    private Group root;
    private ModelMenuPrincipal model;
    private Text txtTitle;
    private Button btnStart, btnOption, btnExit;
    private Rectangle2D psb = Screen.getPrimary().getBounds();
    private GridPane gridMenu;

    ViewMenuPrincipal(Group root, ModelMenuPrincipal model){
        this.root = root;
        this.model = model;

        //Tu géres l'affichage ici //
        //TODO ajouter les boutons restant (btnExit) et faire la mise en forme du Menu ICI //

        txtTitle = initText(150,"HUNGRY FISH");
        txtTitle.setLayoutX(300);
        txtTitle.setLayoutY(200);

        btnStart = initBtnCenter(25,"JOUER");
        btnStart.setLayoutY(300);

        btnOption = initBtnCenter(25,"OPTION");
        btnOption.setLayoutY(400);

        btnExit = initBtnCenter(25,"QUITTER");
        btnExit.setLayoutY(500);


        root.getChildren().clear();
        root.getChildren().add(model.parallax.getRoot());
        root.getChildren().add(txtTitle);
        root.getChildren().add(btnStart);
        root.getChildren().add(btnOption);
        root.getChildren().add(btnExit);


        ////////////////////////////////////////////////////////////
    }

    public Text initText(int fontSize, String textContent){
        Text t = new Text();
        t.setText(textContent);
        t.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontBubbleButt), fontSize));
        t.setRotate(15);
        return t;
    }

    public Button initBtnCenter(int fontSize, String textContent){
        Button b = new Button(textContent);
        double width = 250;
        b.setMinWidth(width);
        double middle = (psb.getWidth()/2) - (width/2);
        b.setLayoutX(middle);
        b.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        b.getStyleClass().add("btn");
        return b;
    }


    public Button initBtn(int fontSize, String textContent){
        Button b = new Button();
        b.setText(textContent);
        b.setFont(Font.loadFont(ViewMenuPrincipal.class.getResourceAsStream(Path.fontWavePool), fontSize));
        return b;
    }

    void setEvents(ControllerMenuPrincipal mc){
        btnStart.setOnMouseClicked(mc);
        btnOption.setOnMouseClicked(mc);
        btnExit.setOnMouseClicked(mc);
        this.root.setOnMouseMoved(mc);
        btnStart.setOnMouseMoved(mc);
        btnOption.setOnMouseMoved(mc);
        btnExit.setOnMouseMoved(mc);
    }

    public Button getBtnStart(){return btnStart;}

    public Button getBtnOption(){return btnOption;}

    public Button getBtnExit(){return btnExit;}

    public Group getRoot(){return root;}

}

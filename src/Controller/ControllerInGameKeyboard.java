package Controller;

import Model.Menu;
import Timeline.JeuTL;
import View.ViewHandler;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.util.Hashtable;

public class ControllerInGameKeyboard implements EventHandler<KeyEvent> {

    private JeuTL jeuTL;
    private ViewHandler launcher;
    private Menu model;
    private Hashtable<KeyCode,Boolean> listKeyPressed= new Hashtable<KeyCode,Boolean>();

    public ControllerInGameKeyboard(ViewHandler launcher, Menu model){
        this.model = model;
        this.launcher = launcher;
    }

    public void startJeuTL(){
        jeuTL = new JeuTL(this);
        this.launcher.setEventHandlerInGameKeyboard(this);
        jeuTL.start();
        launcher.getViewInGame().getRoot().requestFocus();
    }

    public void stopJeuTL(){
        if(jeuTL!=null){
            jeuTL.stop();
            jeuTL.getScroll().getCamera().setLayoutX(0);
            jeuTL.getScroll().getCamera().setLayoutY(0);
            jeuTL = null;
        }
    }


    @Override
    public void handle(KeyEvent event) {
        if (event.getEventType() == KeyEvent.KEY_RELEASED){

            if(listKeyPressed.containsKey(event.getCode())){
                listKeyPressed.replace(event.getCode(),false);
            }else{
                listKeyPressed.put(event.getCode(),false);
            }
        }
        if(event.getEventType() == KeyEvent.KEY_PRESSED){

            if(listKeyPressed.containsKey(event.getCode())){
                listKeyPressed.replace(event.getCode(),true);
            }else{
                listKeyPressed.put(event.getCode(),true);
            }
        }
    }

    public ViewHandler getLauncher() {
        return launcher;
    }

    public Hashtable<KeyCode, Boolean> getListKeyPressed() {
        return listKeyPressed;
    }
}
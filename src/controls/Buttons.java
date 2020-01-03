package controls;

import GUI.Display;
import GUI.SPanel;
import game.Main;
import modes.MultiplayerMode;
import modes.SingleMode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons implements ActionListener{
    SPanel panel;

    public Buttons(SPanel panel) {
        this.panel = panel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(panel.playButton == e.getSource()) {
            panel.setScreenMode(Display.PlayMenu);
        }else if(panel.menuButton == e.getSource()) {
            SingleMode.running = false;
            MultiplayerMode.running = false;
            panel.setScreenMode(Display.Menu);
        }else if(panel.singleButton == e.getSource()) {
            panel.setScreenMode(Display.Game);
            Main.startSinglePlayer(true);
        }else if(panel.localButton == e.getSource()) {
            panel.setScreenMode(Display.LocalGame);
            Main.startLocalPlayer(true);
        }else if(panel.onlineButton == e.getSource()) {
            panel.setScreenMode(Display.OnlineMenu);
        }else if(panel.connectButton == e.getSource()){
            panel.setScreenMode(Display.OnlineGame);
            Main.startOnlineGame(panel.ipTextField.getText());
        }else if(panel.backButton == e.getSource()) {
            panel.setScreenMode(Display.Menu);
        }else if(panel.returnButton == e.getSource()) {
            panel.setScreenMode(Display.PlayMenu);
        }else if(panel.exitButton == e.getSource()) {
            System.exit(0);
        }else if(panel.settingsButton == e.getSource()) {
            panel.setScreenMode(Display.Settings);
        }else if(panel.slowSpeedButton == e.getSource()) {
            if(SingleMode.running == true){
                panel.setScreenMode(Display.Game);
                Main.startSinglePlayer(false);
            } else {
                panel.setScreenMode(Display.LocalGame);
                Main.startLocalPlayer(false);
            }
        } else if (panel.fastSpeedButton == e.getSource()) {
            if(SingleMode.running == true) {
                panel.setScreenMode(Display.Game);
                Main.startSinglePlayer(true);
            } else {
                panel.setScreenMode(Display.LocalGame);
                Main.startLocalPlayer(true);
            }

        }

    }

}

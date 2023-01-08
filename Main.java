import Smart_Home_GUI.GUIGame;

import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    public static void main(String [] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        GUIGame game = new GUIGame();
        game.setGUIHome();
    }
}
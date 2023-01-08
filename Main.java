import Smart_Home_GUI.GUIHome;
import javax.swing.*;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

public class Main {
    public static void main(String [] args) throws Exception{
        UIManager.setLookAndFeel(new NimbusLookAndFeel());
        GUIHome display_sh = new GUIHome();
        display_sh.setGUIHome();
    }
}
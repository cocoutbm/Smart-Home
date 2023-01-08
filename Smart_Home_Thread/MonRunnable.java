package Smart_Home_Thread;

import Smart_Home_GUI.GUIGame;
import Smart_Home_Joueur.Joueur;

import javax.swing.*;

public class MonRunnable extends Thread {

    private Thread thread;
    private boolean isPaused = false;

    public MonRunnable(){
        this.thread = new Thread();
    }

    public void run(Joueur player, double argent) {
        GUIGame game = new GUIGame();
        game.setGUIGame(player);
        thread = new Thread(() -> {
            while (true) {

                try {
                    Thread.sleep(1000); // pause de 5 secondes
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (thread) {
                    while (isPaused) {
                        try {
                            System.out.println("salut");
                            thread.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                game.ModifieMeteo();
                game.ModifieJournee();
                game.update();

            }
        });
        thread.start();

    }

}

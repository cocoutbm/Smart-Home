package Smart_Home_GUI;

import Smart_Home_Joueur.Joueur;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUIHome extends JFrame {

    JFrame main_window = new JFrame("Smart Home");
    Joueur player = new Joueur();


    public GUIHome(){
        super();
    }

    public void setGUIHome() {
        main_window.setVisible(true);
        main_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        main_window.setSize(1366, 768);
        main_window.setLocationRelativeTo(null);

        JPanel main_panel = new JPanel();
        main_window.setContentPane(main_panel);
        main_panel.setLayout(null);
        main_panel.setBackground(Color.blue);


        ImageIcon image_maison = new ImageIcon("C:\\Users\\coco\\maison_finale.png");
        JLabel label1 = new JLabel(image_maison);
        label1.setBounds(300, 50, 800, 600);

        JLabel label2 = new JLabel("SMART HOME", SwingConstants.CENTER);
        label2.setFont(new Font("Sherif", Font.BOLD, 34));
        label2.setBackground(Color.cyan);
        label2.setOpaque(true);
        label2.setBounds(575, 10, 275, 75);

        JButton jouer = new JButton("JOUER");
        jouer.setBounds(85, 375, 150, 100);
        jouer.addActionListener(e -> {
            JFrame pseudo_window = new JFrame("Pseudo du Joueur");
            pseudo_window.setVisible(true);
            pseudo_window.setSize(400, 250);
            pseudo_window.setLocationRelativeTo(null);

            JPanel panel_pseudo = new JPanel();
            pseudo_window.setContentPane(panel_pseudo);
            panel_pseudo.setLayout(null);

            JLabel label_pseudo = new JLabel("Choisi ton pseudo");
            label_pseudo.setFont(new Font("Sherif", Font.BOLD, 14));
            label_pseudo.setBounds(120, 25, 200, 25);

            JTextField pseudo_text = new JTextField("Pseudo");
            pseudo_text.setBounds(85, 75, 200, 50);
            pseudo_text.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pseudo_text.setText("");
                }
            });

            JButton pseudo_ok = new JButton("OK");
            pseudo_ok.setBounds(135, 135, 100, 50);
            pseudo_ok.addActionListener(e1 -> {
                player.setPseudo(pseudo_text.getText());
                pseudo_window.setVisible(false);
                main_window.setVisible(false);

                GUIGame game_sh = new GUIGame();
                game_sh.setGUIGame(player);

            });


            panel_pseudo.add(label_pseudo);
            panel_pseudo.add(pseudo_text);
            panel_pseudo.add(pseudo_ok);

        });
        main_panel.add(jouer);
        main_panel.add(label1);
        main_panel.add(label2);
    }
}

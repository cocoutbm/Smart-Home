package Smart_Home_GUI;

import Smart_Home_Joueur.Joueur;
import Smart_Home_Systeme.*;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GUIGame extends JFrame{

    private JFrame game_window;

    public GUIGame(){
        super();
        this.game_window = new JFrame("Smart Home");
    }

    public void setGUIGame(Joueur j){

        Meteo meteo = new Meteo();
        Maison smart_home = new Maison(meteo);
        Boutique boutique_EE = new Boutique();
        BonTemps bon_temps = new BonTemps();
        MauvaisTemps mauvais_temps = new MauvaisTemps();
        Random rand = new Random();
        Date time = new Date(System.currentTimeMillis());
        time.setHours(8);
        time.setMinutes(0);
        time.setSeconds(0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm dd/MM");


        Thread thread = new Thread(() -> {
            while (j.getArgent() != 0){

                try {
                    Thread.sleep(1000); // pause de 5 secondes

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                int choix = rand.nextInt(20);
                System.out.println(choix);
                if(choix % 2 == 0){
                    mauvais_temps.ModifieMauvaisTemps();
                    bon_temps.setTemperature(mauvais_temps.getTemperature());
                    bon_temps.setHumidite(mauvais_temps.getHumidite());
                    meteo.ModifieMeteoMT(mauvais_temps);
                } else {
                    bon_temps.ModifieBonTemps();
                    mauvais_temps.setTemperature(bon_temps.getTemperature());
                    mauvais_temps.setHumidite(bon_temps.getHumidite());
                    meteo.ModifieMeteoBT(bon_temps);
                }
                smart_home.ModifieMaison(meteo);
                smart_home.setLuminosite();

                System.out.println(bon_temps.getTemperature() + " " + mauvais_temps.getTemperature());
                System.out.println(meteo.getTemperature() + " " + meteo.getHumidite());
                System.out.println(smart_home.getTemperature() + " " + smart_home.getHumidite() + "\n");

                game_window.setVisible(true);
                game_window.setDefaultCloseOperation(EXIT_ON_CLOSE);
                game_window.setSize(1366, 768);
                game_window.setLocationRelativeTo(null);

                JPanel game_panel = new JPanel();
                game_window.setContentPane(game_panel);
                game_panel.setLayout(null);
                game_panel.setBackground(Color.blue);

                ImageIcon maison = new ImageIcon("C:\\Users\\coco\\maison_finale.png");
                JLabel game_label1 = new JLabel(maison);
                game_label1.setBounds(300, 50, 800, 600);

                JLabel game_label2 = new JLabel("Pseudo: " + j.getPseudo(), SwingConstants.CENTER);
                game_label2.setFont(new Font("Sherif", Font.BOLD, 18));
                game_label2.setBackground(Color.green);
                game_label2.setOpaque(true);
                game_label2.setBounds(50, 15, 250, 50);

                JLabel game_label3 = new JLabel("SMART HOME", SwingConstants.CENTER);
                game_label3.setFont(new Font("Sherif", Font.BOLD, 34));
                game_label3.setBackground(Color.cyan);
                game_label3.setOpaque(true);
                game_label3.setBounds(575, 10, 275, 75);

                JLabel game_label4 = new JLabel("Argent: " + j.getArgent() + " €", SwingConstants.CENTER);
                game_label4.setFont(new Font("Sherif", Font.BOLD, 18));
                game_label4.setBackground(Color.green);
                game_label4.setOpaque(true);
                game_label4.setBounds(1000, 15, 250, 50);

                JLabel game_label5 = new JLabel("Jour n°: " + j.getNbJourSurvie(), SwingConstants.CENTER);
                game_label5.setText("Jour n°: " + j.getNbJourSurvie());
                game_label5.setFont(new Font("Sherif", Font.BOLD, 18));
                game_label5.setBackground(Color.green);
                game_label5.setOpaque(true);
                game_label5.setBounds(50, 80, 250, 50);

                JLabel meteo_externe1 = new JLabel("Météo Externe");
                meteo_externe1.setBackground(Color.ORANGE);
                meteo_externe1.setOpaque(true);
                meteo_externe1.setBounds(30, 300, 250, 25);

                JLabel meteo_externe2 = new JLabel("- Température: " + meteo.getTemperature() + " °C", SwingConstants.CENTER);
                meteo_externe2.setBackground(Color.ORANGE);
                meteo_externe2.setOpaque(true);
                meteo_externe2.setBounds(30, 325, 250, 25);

                JLabel meteo_externe3 = new JLabel("- Humidité: " + meteo.getHumidite() + " %", SwingConstants.CENTER);
                meteo_externe3.setBackground(Color.ORANGE);
                meteo_externe3.setOpaque(true);
                meteo_externe3.setBounds(30, 350, 250, 25);

                JLabel temps = new JLabel("Temps : " + smart_home.getLuminosite());
                temps.setText("Temps : " + smart_home.getLuminosite());
                temps.setBackground(Color.ORANGE);
                temps.setOpaque(true);
                temps.setBounds(50, 150, 400, 25);

                JLabel label_consommation = new JLabel("Tu as consommé " + smart_home.getConsommationtotale() + " W/h sur les 9000 autorisés");
                label_consommation.setBackground(Color.GREEN);
                label_consommation.setOpaque(true);
                label_consommation.setBounds(1000, 85, 300, 25);

                JLabel meteo_interne1 = new JLabel("Météo Interne de la Maison");
                meteo_interne1.setBackground(Color.ORANGE);
                meteo_interne1.setOpaque(true);
                meteo_interne1.setBounds(1115, 300, 150, 25);

                JLabel meteo_interne2 = new JLabel("- Température: " + smart_home.getTemperature() + " °C", SwingConstants.CENTER);
                meteo_interne2.setBackground(Color.ORANGE);
                meteo_interne2.setOpaque(true);
                meteo_interne2.setBounds(1115, 325, 150, 25);

                JLabel meteo_interne3 = new JLabel("- Humidité: " + smart_home.getHumidite() + " %", SwingConstants.CENTER);
                meteo_interne3.setBackground(Color.ORANGE);
                meteo_interne3.setOpaque(true);
                meteo_interne3.setBounds(1115, 350, 150, 25);

                JButton bouton_boutique = new JButton("BOUTIQUE");
                bouton_boutique.setFont(new Font("Sherif", Font.BOLD, 18));
                bouton_boutique.setBounds(1115, 625,200, 50);
                bouton_boutique.addActionListener(e -> {
                    JFrame boutique = new JFrame("Boutique");
                    boutique.setVisible(true);
                    boutique.setSize(650, 350);
                    boutique.setLocationRelativeTo(null);

                    JPanel panel_boutique = new JPanel();
                    boutique.setContentPane(panel_boutique);
                    panel_boutique.setLayout(null);

                    JCheckBox checkBox1 = new JCheckBox("Radiateur Lowcost : " + boutique_EE.getRadiateur1().getPrix() + " €");
                    checkBox1.setBounds(30, 15, 200, 10);
                    if(!boutique_EE.getRadiateur1().isEstAchete()){
                        checkBox1.setBackground(Color.red);
                        checkBox1.setOpaque(true);
                    }
                    checkBox1.addActionListener(e1 -> {
                        j.AcheterEquip(boutique_EE.getRadiateur1(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getRadiateur1().setEstAchete(true);
                        checkBox1.setBackground(Color.green);
                        checkBox1.setOpaque(true);
                    });

                    JCheckBox checkBox2 = new JCheckBox("Radiateur Populaire : " + boutique_EE.getRadiateur2().getPrix() + " €");
                    checkBox2.setBounds(30, 35, 200, 10);
                    if(!boutique_EE.getRadiateur2().isEstAchete()){
                        checkBox2.setBackground(Color.red);
                        checkBox2.setOpaque(true);
                    }
                    checkBox2.addActionListener(e12 -> {
                        j.AcheterEquip(boutique_EE.getRadiateur2(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getRadiateur2().setEstAchete(true);
                        checkBox2.setBackground(Color.green);
                        checkBox2.setOpaque(true);
                    });

                    JCheckBox checkBox3 = new JCheckBox("Radiateur haut de gamme : " + boutique_EE.getRadiateur3().getPrix() + " €");
                    checkBox3.setBounds(30, 55, 200, 10);
                    if(!boutique_EE.getRadiateur3().isEstAchete()){
                        checkBox3.setBackground(Color.red);
                        checkBox3.setOpaque(true);
                    }
                    checkBox3.addActionListener(e13 -> {
                        j.AcheterEquip(boutique_EE.getRadiateur3(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getRadiateur3().setEstAchete(true);
                        checkBox3.setBackground(Color.green);
                        checkBox3.setOpaque(true);
                    });

                    JCheckBox checkBox4 = new JCheckBox("Ventilateur Lowcost : " + boutique_EE.getVentilateur1().getPrix() + " €");
                    checkBox4.setBounds(30, 75, 200, 10);
                    if(!boutique_EE.getVentilateur1().isEstAchete()){
                        checkBox4.setBackground(Color.red);
                        checkBox4.setOpaque(true);
                    }
                    checkBox4.addActionListener(e14 -> {
                        j.AcheterEquip(boutique_EE.getVentilateur1(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getVentilateur1().setEstAchete(true);
                        checkBox4.setBackground(Color.green);
                        checkBox4.setOpaque(true);
                    });

                    JCheckBox checkBox5 = new JCheckBox("Ventilateur Populaire : " + boutique_EE.getVentilateur2().getPrix() + " €");
                    checkBox5.setBounds(30, 95, 200, 10);
                    if(!boutique_EE.getVentilateur2().isEstAchete()){
                        checkBox5.setBackground(Color.red);
                        checkBox5.setOpaque(true);
                    }
                    checkBox5.addActionListener(e15 -> {
                        j.AcheterEquip(boutique_EE.getVentilateur2(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getVentilateur2().setEstAchete(true);
                        checkBox5.setBackground(Color.green);
                        checkBox5.setOpaque(true);
                    });

                    JCheckBox checkBox6 = new JCheckBox("Ventilateur haut de gamme : " + boutique_EE.getVentilateur3().getPrix() + " €");
                    checkBox6.setBounds(30, 115, 200, 10);
                    if(!boutique_EE.getVentilateur3().isEstAchete()){
                        checkBox6.setBackground(Color.red);
                        checkBox6.setOpaque(true);
                    }
                    checkBox6.addActionListener(e16 -> {
                        j.AcheterEquip(boutique_EE.getVentilateur3(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getVentilateur3().setEstAchete(true);
                        checkBox6.setBackground(Color.green);
                        checkBox6.setOpaque(true);
                    });

                    JCheckBox checkBox7 = new JCheckBox("Ampoule Qualité1 : " + boutique_EE.getAmpoule1().getPrix() + " €");
                    checkBox7.setBounds(30, 135, 200, 10);
                    if(!boutique_EE.getAmpoule1().isEstAchete()){
                        checkBox7.setBackground(Color.red);
                        checkBox7.setOpaque(true);
                    }
                    checkBox7.addActionListener(e17 -> {
                        j.AcheterEquip(boutique_EE.getAmpoule1(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getAmpoule1().setEstAchete(true);
                        checkBox7.setBackground(Color.green);
                        checkBox7.setOpaque(true);
                    });

                    JCheckBox checkBox8 = new JCheckBox("Ampoule Qualité2 : " + boutique_EE.getAmpoule2().getPrix() + " €");
                    checkBox8.setBounds(30, 155, 200, 10);
                    if(!boutique_EE.getAmpoule2().isEstAchete()){
                        checkBox8.setBackground(Color.red);
                        checkBox8.setOpaque(true);
                    }
                    checkBox8.addActionListener(e18 -> {
                        j.AcheterEquip(boutique_EE.getAmpoule2(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getAmpoule2().setEstAchete(true);
                        checkBox8.setBackground(Color.green);
                        checkBox8.setOpaque(true);
                    });

                    JCheckBox checkBox9 = new JCheckBox("Ampoule Qualité3 : " + + boutique_EE.getAmpoule3().getPrix() + " €");
                    checkBox9.setBounds(30, 175, 200, 10);
                    if(!boutique_EE.getAmpoule3().isEstAchete()){
                        checkBox9.setBackground(Color.red);
                        checkBox9.setOpaque(true);
                    }
                    checkBox9.addActionListener(e19 -> {
                        j.AcheterEquip(boutique_EE.getAmpoule3(), smart_home.getTab_EE());
                        game_label4.setText("Argent: " + j.getArgent() + " €");
                        boutique_EE.getAmpoule3().setEstAchete(true);
                        checkBox9.setBackground(Color.green);
                        checkBox9.setOpaque(true);
                    });

                    JTextField info = new JTextField("Les Equipements Energetiques qui sont achetés sont en vert ceux qui ne sont pas achetés sont en rouge.");
                    info.setBounds(25, 200, 600, 30);

                    JButton boutique_terminer = new JButton("TERMINER");
                    boutique_terminer.setBounds(250, 250, 100, 25);
                    boutique_terminer.addActionListener(e110 -> boutique.setVisible(false));

                    panel_boutique.add(checkBox1);
                    panel_boutique.add(checkBox2);
                    panel_boutique.add(checkBox3);
                    panel_boutique.add(checkBox4);
                    panel_boutique.add(checkBox5);
                    panel_boutique.add(checkBox6);
                    panel_boutique.add(checkBox7);
                    panel_boutique.add(checkBox8);
                    panel_boutique.add(checkBox9);
                    panel_boutique.add(info);
                    panel_boutique.add(boutique_terminer);

                });

                JButton bouton_equipements = new JButton("Liste des Équipements");
                bouton_equipements.setFont(new Font("Sherif", Font.BOLD, 14));
                bouton_equipements.setBounds(1115, 550, 200, 25);
                bouton_equipements.addActionListener(e -> {
                    JFrame equipement = new JFrame("Liste des Équipements");
                    equipement.setVisible(true);
                    equipement.setSize(650, 550);
                    equipement.setLocationRelativeTo(null);

                    JPanel panel_equipement = new JPanel();
                    equipement.setContentPane(panel_equipement);
                    panel_equipement.setLayout(null);

                    JLabel label_ED = new JLabel("Équipements Domestiques");
                    label_ED.setBounds(30, 15, 250, 10);

                    JCheckBox Equip_checkBox1 = new JCheckBox("Douche Activé");
                    Equip_checkBox1.setBounds(30, 55, 200, 10);
                    if (smart_home.getDouche().isEstUtilise()){
                        Equip_checkBox1.setBackground(Color.green);
                        Equip_checkBox1.setOpaque(true);
                    } else {
                        Equip_checkBox1.setBackground(Color.orange);
                        Equip_checkBox1.setOpaque(true);
                    }
                    Equip_checkBox1.addActionListener(e112 -> smart_home.getDouche().ustiliserEquipementsDomestiques(true));

                    JCheckBox Equip_checkBox2 = new JCheckBox("Douche Désactivé");
                    Equip_checkBox2.setBounds(250, 55, 200, 10);
                    if (smart_home.getDouche().isEstUtilise()){
                        Equip_checkBox2.setBackground(Color.green);
                        Equip_checkBox2.setOpaque(true);
                    } else {
                        Equip_checkBox2.setBackground(Color.orange);
                        Equip_checkBox2.setOpaque(true);
                    }
                    Equip_checkBox2.addActionListener(e111 -> smart_home.getDouche().ustiliserEquipementsDomestiques(false));

                    JCheckBox Equip_checkBox3 = new JCheckBox("Lampes Activé");
                    Equip_checkBox3.setBounds(30, 75, 200, 10);
                    if (smart_home.getLampes().isEstUtilise()){
                        Equip_checkBox3.setBackground(Color.green);
                        Equip_checkBox3.setOpaque(true);
                    } else {
                        Equip_checkBox3.setBackground(Color.orange);
                        Equip_checkBox3.setOpaque(true);
                    }
                    Equip_checkBox3.addActionListener(e113 -> smart_home.getLampes().ustiliserEquipementsDomestiques(true));

                    JCheckBox Equip_checkBox4 = new JCheckBox("Lampes Désactivé");
                    Equip_checkBox4.setBounds(250, 75, 200, 10);
                    if (smart_home.getLampes().isEstUtilise()){
                        Equip_checkBox4.setBackground(Color.green);
                        Equip_checkBox4.setOpaque(true);
                    } else {
                        Equip_checkBox4.setBackground(Color.orange);
                        Equip_checkBox4.setOpaque(true);
                    }
                    Equip_checkBox4.addActionListener(e114 -> smart_home.getLampes().ustiliserEquipementsDomestiques(false));

                    JCheckBox Equip_checkBox5 = new JCheckBox("Four Activé");
                    Equip_checkBox5.setBounds(30, 95, 200, 10);
                    if (smart_home.getFour().isEstUtilise()){
                        Equip_checkBox5.setBackground(Color.green);
                        Equip_checkBox5.setOpaque(true);
                    } else {
                        Equip_checkBox5.setBackground(Color.orange);
                        Equip_checkBox5.setOpaque(true);
                    }
                    Equip_checkBox5.addActionListener(e115 -> smart_home.getFour().ustiliserEquipementsDomestiques(true));

                    JCheckBox Equip_checkBox6 = new JCheckBox("Four Désactivé");
                    Equip_checkBox6.setBounds(250, 95, 200, 10);
                    if (smart_home.getFour().isEstUtilise()){
                        Equip_checkBox6.setBackground(Color.green);
                        Equip_checkBox6.setOpaque(true);
                    } else {
                        Equip_checkBox6.setBackground(Color.orange);
                        Equip_checkBox6.setOpaque(true);
                    }
                    Equip_checkBox6.addActionListener(e116 -> smart_home.getFour().ustiliserEquipementsDomestiques(false));

                    JCheckBox Equip_checkBox7 = new JCheckBox("Télévision Activé");
                    Equip_checkBox7.setBounds(30, 115, 200, 10);
                    if (smart_home.getTelevision().isEstUtilise()){
                        Equip_checkBox7.setBackground(Color.green);
                        Equip_checkBox7.setOpaque(true);
                    } else {
                        Equip_checkBox7.setBackground(Color.orange);
                        Equip_checkBox7.setOpaque(true);
                    }
                    Equip_checkBox7.addActionListener(e117 -> smart_home.getTelevision().ustiliserEquipementsDomestiques(true));

                    JCheckBox Equip_checkBox8 = new JCheckBox("Télévision Désactivé");
                    Equip_checkBox8.setBounds(250, 115, 200, 10);
                    if (smart_home.getTelevision().isEstUtilise()){
                        Equip_checkBox8.setBackground(Color.green);
                        Equip_checkBox8.setOpaque(true);
                    } else {
                        Equip_checkBox8.setBackground(Color.orange);
                        Equip_checkBox8.setOpaque(true);
                    }
                    Equip_checkBox8.addActionListener(e118 -> smart_home.getTelevision().ustiliserEquipementsDomestiques(false));

                    JLabel label_EE = new JLabel("Équipements Énergétiques");
                    label_EE.setBounds(30, 145, 250, 20);

                    JCheckBox Equip_checkBox9 = new JCheckBox("Radiateur Lowcost Activé");
                    Equip_checkBox9.setBounds(30, 175, 200, 10);
                    if(boutique_EE.getRadiateur1().isEstAchete() && boutique_EE.getRadiateur1().isEstUtilise()){
                        Equip_checkBox9.setBackground(Color.green);
                        Equip_checkBox9.setOpaque(true);
                    } else if (boutique_EE.getRadiateur1().isEstAchete() && !boutique_EE.getRadiateur1().isEstUtilise()){
                        Equip_checkBox9.setBackground(Color.orange);
                        Equip_checkBox9.setOpaque(true);
                    } else {
                        Equip_checkBox9.setBackground(Color.red);
                        Equip_checkBox9.setOpaque(true);
                    }
                    Equip_checkBox9.addActionListener(e119 -> {
                        boutique_EE.getRadiateur1().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(1);
                        smart_home.setHumidite(-2);
                    });

                    JCheckBox Equip_checkBox10 = new JCheckBox("Radiateur Lowcost  Désactivé");
                    Equip_checkBox10.setBounds(250, 175, 200, 10);
                    if(boutique_EE.getRadiateur1().isEstAchete() && boutique_EE.getRadiateur1().isEstUtilise()){
                        Equip_checkBox10.setBackground(Color.green);
                        Equip_checkBox10.setOpaque(true);
                    } else if (boutique_EE.getRadiateur1().isEstAchete() && !boutique_EE.getRadiateur1().isEstUtilise()){
                        Equip_checkBox10.setBackground(Color.orange);
                        Equip_checkBox10.setOpaque(true);
                    } else {
                        Equip_checkBox10.setBackground(Color.red);
                        Equip_checkBox10.setOpaque(true);
                    }
                    Equip_checkBox10.addActionListener(e120 -> boutique_EE.getRadiateur1().utiliserEquipementsEnergetiques(false));

                    JCheckBox Equip_checkBox11 = new JCheckBox("Radiateur populaire Activé");
                    Equip_checkBox11.setBounds(30, 195, 200, 10);
                    if(boutique_EE.getRadiateur2().isEstAchete() && boutique_EE.getRadiateur2().isEstUtilise()){
                        Equip_checkBox11.setBackground(Color.green);
                        Equip_checkBox11.setOpaque(true);
                    } else if (boutique_EE.getRadiateur2().isEstAchete() && !boutique_EE.getRadiateur2().isEstUtilise()){
                        Equip_checkBox11.setBackground(Color.orange);
                        Equip_checkBox11.setOpaque(true);
                    } else {
                        Equip_checkBox11.setBackground(Color.red);
                        Equip_checkBox11.setOpaque(true);
                    }
                    Equip_checkBox11.addActionListener(e121 -> {
                        boutique_EE.getRadiateur2().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(2);
                        smart_home.setHumidite(-3.5);
                    });

                    JCheckBox Equip_checkBox12 = new JCheckBox("Radiateur populaire Désactivé");
                    Equip_checkBox12.setBounds(250, 195, 200, 10);
                    if(boutique_EE.getRadiateur2().isEstAchete() && boutique_EE.getRadiateur2().isEstUtilise()){
                        Equip_checkBox12.setBackground(Color.green);
                        Equip_checkBox12.setOpaque(true);
                    } else if (boutique_EE.getRadiateur2().isEstAchete() && !boutique_EE.getRadiateur2().isEstUtilise()){
                        Equip_checkBox12.setBackground(Color.orange);
                        Equip_checkBox12.setOpaque(true);
                    } else {
                        Equip_checkBox12.setBackground(Color.red);
                        Equip_checkBox12.setOpaque(true);
                    }
                    Equip_checkBox12.addActionListener(e122 -> boutique_EE.getRadiateur2().utiliserEquipementsEnergetiques(false));

                    JCheckBox Equip_checkBox13 = new JCheckBox("Radiateur haut de gamme Activé");
                    Equip_checkBox13.setBounds(30, 215, 200, 10);
                    if(boutique_EE.getRadiateur3().isEstAchete() && boutique_EE.getRadiateur3().isEstUtilise()){
                        Equip_checkBox13.setBackground(Color.green);
                        Equip_checkBox13.setOpaque(true);
                    } else if (boutique_EE.getRadiateur3().isEstAchete() && !boutique_EE.getRadiateur3().isEstUtilise()){
                        Equip_checkBox13.setBackground(Color.orange);
                        Equip_checkBox13.setOpaque(true);
                    } else {
                        Equip_checkBox13.setBackground(Color.red);
                        Equip_checkBox13.setOpaque(true);
                    }
                    Equip_checkBox13.addActionListener(e123 -> {
                        boutique_EE.getRadiateur3().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(3);
                        smart_home.setHumidite(-5);
                    });

                    JCheckBox Equip_checkBox14 = new JCheckBox("Radiateur haut de gamme Désctivé");
                    Equip_checkBox14.setBounds(250, 215, 250, 10);
                    if(boutique_EE.getRadiateur3().isEstAchete() && boutique_EE.getRadiateur3().isEstUtilise()){
                        Equip_checkBox14.setBackground(Color.green);
                        Equip_checkBox14.setOpaque(true);
                    } else if (boutique_EE.getRadiateur3().isEstAchete() && !boutique_EE.getRadiateur3().isEstUtilise()){
                        Equip_checkBox14.setBackground(Color.orange);
                        Equip_checkBox14.setOpaque(true);
                    } else {
                        Equip_checkBox14.setBackground(Color.red);
                        Equip_checkBox14.setOpaque(true);
                    }
                    Equip_checkBox14.addActionListener(e124 -> boutique_EE.getRadiateur3().utiliserEquipementsEnergetiques(false));

                    JCheckBox Equip_checkBox15 = new JCheckBox("Ventilateur Lowcost Activé");
                    Equip_checkBox15.setBounds(30, 235, 200, 10);
                    if(boutique_EE.getVentilateur1().isEstAchete() && boutique_EE.getVentilateur1().isEstUtilise()){
                        Equip_checkBox15.setBackground(Color.green);
                        Equip_checkBox15.setOpaque(true);
                    } else if (boutique_EE.getVentilateur1().isEstAchete() && !boutique_EE.getVentilateur1().isEstUtilise()){
                        Equip_checkBox15.setBackground(Color.orange);
                        Equip_checkBox15.setOpaque(true);
                    } else {
                        Equip_checkBox15.setBackground(Color.red);
                        Equip_checkBox15.setOpaque(true);
                    }
                    Equip_checkBox15.addActionListener(e125 -> {
                        boutique_EE.getVentilateur1().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(-1);
                        smart_home.setHumidite(2);
                    });

                    JCheckBox Equip_checkBox16 = new JCheckBox("Ventilateur Lowcost Désactivé");
                    Equip_checkBox16.setBounds(250, 235, 200, 10);
                    if(boutique_EE.getVentilateur1().isEstAchete() && boutique_EE.getVentilateur1().isEstUtilise()){
                        Equip_checkBox16.setBackground(Color.green);
                        Equip_checkBox16.setOpaque(true);
                    } else if (boutique_EE.getVentilateur1().isEstAchete() && !boutique_EE.getVentilateur1().isEstUtilise()){
                        Equip_checkBox16.setBackground(Color.orange);
                        Equip_checkBox16.setOpaque(true);
                    } else {
                        Equip_checkBox16.setBackground(Color.red);
                        Equip_checkBox16.setOpaque(true);
                    }
                    Equip_checkBox16.addActionListener(e126 -> boutique_EE.getVentilateur1().utiliserEquipementsEnergetiques(false));

                    JCheckBox Equip_checkBox17 = new JCheckBox("Ventilateur populaire Activé");
                    Equip_checkBox17.setBounds(30, 255, 200, 10);
                    if(boutique_EE.getVentilateur2().isEstAchete() && boutique_EE.getVentilateur2().isEstUtilise()){
                        Equip_checkBox17.setBackground(Color.green);
                        Equip_checkBox17.setOpaque(true);
                    } else if (boutique_EE.getVentilateur2().isEstAchete() && !boutique_EE.getVentilateur2().isEstUtilise()){
                        Equip_checkBox17.setBackground(Color.orange);
                        Equip_checkBox17.setOpaque(true);
                    } else {
                        Equip_checkBox17.setBackground(Color.red);
                        Equip_checkBox17.setOpaque(true);
                    }
                    Equip_checkBox17.addActionListener(e127 -> {
                        boutique_EE.getVentilateur2().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(-2);
                        smart_home.setHumidite(3.5);
                    });

                    JCheckBox Equip_checkBox18 = new JCheckBox("Ventilateur populaire Désactivé");
                    Equip_checkBox18.setBounds(250, 255, 200, 10);
                    if(boutique_EE.getVentilateur2().isEstAchete() && boutique_EE.getVentilateur2().isEstUtilise()){
                        Equip_checkBox18.setBackground(Color.green);
                        Equip_checkBox18.setOpaque(true);
                    } else if (boutique_EE.getVentilateur2().isEstAchete() && !boutique_EE.getVentilateur2().isEstUtilise()){
                        Equip_checkBox18.setBackground(Color.orange);
                        Equip_checkBox18.setOpaque(true);
                    } else {
                        Equip_checkBox18.setBackground(Color.red);
                        Equip_checkBox18.setOpaque(true);
                    }
                    Equip_checkBox18.addActionListener(e128 -> boutique_EE.getVentilateur2().utiliserEquipementsEnergetiques(false));

                    JCheckBox Equip_checkBox19 = new JCheckBox("Ventilateur haut de gamme Activé");
                    Equip_checkBox19.setBounds(30, 275, 225, 10);
                    if(boutique_EE.getVentilateur3().isEstAchete() && boutique_EE.getVentilateur3().isEstUtilise()){
                        Equip_checkBox19.setBackground(Color.green);
                        Equip_checkBox19.setOpaque(true);
                    } else if (boutique_EE.getVentilateur3().isEstAchete() && !boutique_EE.getVentilateur3().isEstUtilise()){
                        Equip_checkBox19.setBackground(Color.orange);
                        Equip_checkBox19.setOpaque(true);
                    } else {
                        Equip_checkBox19.setBackground(Color.red);
                        Equip_checkBox19.setOpaque(true);
                    }
                    Equip_checkBox19.addActionListener(e129 -> {
                        boutique_EE.getVentilateur3().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(-3);
                        smart_home.setHumidite(5);
                    });

                    JCheckBox Equip_checkBox20 = new JCheckBox("Ventilateur haut de gamme Désactivé");
                    Equip_checkBox20.setBounds(250, 275, 225, 10);
                    if(boutique_EE.getVentilateur3().isEstAchete() && boutique_EE.getVentilateur3().isEstUtilise()){
                        Equip_checkBox20.setBackground(Color.green);
                        Equip_checkBox20.setOpaque(true);
                    } else if (boutique_EE.getVentilateur3().isEstAchete() && !boutique_EE.getVentilateur3().isEstUtilise()){
                        Equip_checkBox20.setBackground(Color.orange);
                        Equip_checkBox20.setOpaque(true);
                    } else {
                        Equip_checkBox20.setBackground(Color.red);
                        Equip_checkBox20.setOpaque(true);
                    }
                    Equip_checkBox20.addActionListener(e130 -> boutique_EE.getVentilateur3().utiliserEquipementsEnergetiques(false));

                    JCheckBox Equip_checkBox21 = new JCheckBox("Ampoule Qualité1 Activé");
                    Equip_checkBox21.setBounds(30, 295, 200, 10);
                    if(boutique_EE.getAmpoule1().isEstAchete() && boutique_EE.getAmpoule1().isEstUtilise()){
                        Equip_checkBox21.setBackground(Color.green);
                        Equip_checkBox21.setOpaque(true);
                    } else if (boutique_EE.getAmpoule1().isEstAchete() && !boutique_EE.getAmpoule1().isEstUtilise()){
                        Equip_checkBox21.setBackground(Color.orange);
                        Equip_checkBox21.setOpaque(true);
                    } else {
                        Equip_checkBox21.setBackground(Color.red);
                        Equip_checkBox21.setOpaque(true);
                    }
                    Equip_checkBox21.addActionListener(e131 -> {
                        boutique_EE.getAmpoule1().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(0.33);
                        smart_home.setHumidite(0.5);
                    });

                    JCheckBox Equip_checkBox22 = new JCheckBox("Ampoule Qualité1 Désactivé");
                    Equip_checkBox22.setBounds(250, 295, 250, 10);
                    if(boutique_EE.getAmpoule1().isEstAchete() && boutique_EE.getAmpoule1().isEstUtilise()){
                        Equip_checkBox22.setBackground(Color.green);
                        Equip_checkBox22.setOpaque(true);
                    } else if (boutique_EE.getAmpoule1().isEstAchete() && !boutique_EE.getAmpoule1().isEstUtilise()){
                        Equip_checkBox22.setBackground(Color.orange);
                        Equip_checkBox22.setOpaque(true);
                    } else {
                        Equip_checkBox22.setBackground(Color.red);
                        Equip_checkBox22.setOpaque(true);
                    }
                    Equip_checkBox22.addActionListener(e132 -> boutique_EE.getAmpoule1().utiliserEquipementsEnergetiques(false));

                    JCheckBox Equip_checkBox23 = new JCheckBox("Ampoule Qualité2 Activé");
                    Equip_checkBox23.setBounds(30, 315, 200, 10);
                    if(boutique_EE.getAmpoule2().isEstAchete() && boutique_EE.getAmpoule2().isEstUtilise()){
                        Equip_checkBox23.setBackground(Color.green);
                        Equip_checkBox23.setOpaque(true);
                    } else if (boutique_EE.getAmpoule2().isEstAchete() && !boutique_EE.getAmpoule2().isEstUtilise()){
                        Equip_checkBox23.setBackground(Color.orange);
                        Equip_checkBox23.setOpaque(true);
                    } else {
                        Equip_checkBox23.setBackground(Color.red);
                        Equip_checkBox23.setOpaque(true);
                    }
                    Equip_checkBox23.addActionListener(e133 -> {
                        boutique_EE.getAmpoule2().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(0.67);
                        smart_home.setHumidite(1);
                    });

                    JCheckBox Equip_checkBox24 = new JCheckBox("Ampoule Qualité2 Désactivé");
                    Equip_checkBox24.setBounds(250, 315, 250, 10);
                    if(boutique_EE.getAmpoule2().isEstAchete() && boutique_EE.getAmpoule2().isEstUtilise()){
                        Equip_checkBox24.setBackground(Color.green);
                        Equip_checkBox24.setOpaque(true);
                    } else if (boutique_EE.getAmpoule2().isEstAchete() && !boutique_EE.getAmpoule2().isEstUtilise()){
                        Equip_checkBox24.setBackground(Color.orange);
                        Equip_checkBox24.setOpaque(true);
                    } else {
                        Equip_checkBox24.setBackground(Color.red);
                        Equip_checkBox24.setOpaque(true);
                    }
                    Equip_checkBox24.addActionListener(e134 -> boutique_EE.getAmpoule2().utiliserEquipementsEnergetiques(false));

                    JCheckBox Equip_checkBox25 = new JCheckBox("Ampoule Qualité3 Activé");
                    Equip_checkBox25.setBounds(30, 335, 200, 10);
                    if(boutique_EE.getAmpoule3().isEstAchete() && boutique_EE.getAmpoule3().isEstUtilise()){
                        Equip_checkBox25.setBackground(Color.green);
                        Equip_checkBox25.setOpaque(true);
                    } else if (boutique_EE.getAmpoule3().isEstAchete() && !boutique_EE.getAmpoule3().isEstUtilise()){
                        Equip_checkBox25.setBackground(Color.orange);
                        Equip_checkBox25.setOpaque(true);
                    } else {
                        Equip_checkBox25.setBackground(Color.red);
                        Equip_checkBox25.setOpaque(true);
                    }
                    Equip_checkBox25.addActionListener(e135 -> {
                        boutique_EE.getAmpoule3().utiliserEquipementsEnergetiques(true);
                        smart_home.setTemperature(1);
                        smart_home.setHumidite(1.5);
                    });

                    JCheckBox Equip_checkBox26 = new JCheckBox("Ampoule Qualité3 Désactivé");
                    Equip_checkBox26.setBounds(250, 335, 250, 10);
                    if(boutique_EE.getAmpoule3().isEstAchete() && boutique_EE.getAmpoule3().isEstUtilise()){
                        Equip_checkBox26.setBackground(Color.green);
                        Equip_checkBox26.setOpaque(true);
                    } else if (boutique_EE.getAmpoule3().isEstAchete() && !boutique_EE.getAmpoule3().isEstUtilise()){
                        Equip_checkBox26.setBackground(Color.orange);
                        Equip_checkBox26.setOpaque(true);
                    } else {
                        Equip_checkBox26.setBackground(Color.red);
                        Equip_checkBox26.setOpaque(true);
                    }
                    Equip_checkBox26.addActionListener(e136 -> boutique_EE.getAmpoule3().utiliserEquipementsEnergetiques(false));

                    JTextArea info = new JTextArea("Les Equipements Domestiques utilisé sont en vert \nLes Equipements Domestiques non utilisé sont en orange \nLes Equipements Energetiques achetés et utilisé sont en vert \nLes Equipements Energetiques achetés et non utilisé sont en orange \nLes Equipements Energetiques non achetés et non utilisé sont en rouge");
                    info.setBounds(25, 365, 600, 95);

                    JButton equipement_terminer = new JButton("TERMINER");
                    equipement_terminer.setBounds(225, 475, 100, 25);
                    equipement_terminer.addActionListener(e137 -> {
                        equipement.setVisible(false);
                        smart_home.calculConsommationtotale();
                        label_consommation.setText("Tu as consommé " + smart_home.getConsommationtotale() + " W/h sur les 8000 autorisés");
                        System.out.println(smart_home.getConsommationtotale());
                    });

                    panel_equipement.add(label_ED);
                    panel_equipement.add(label_EE);
                    panel_equipement.add(Equip_checkBox1);
                    panel_equipement.add(Equip_checkBox2);
                    panel_equipement.add(Equip_checkBox3);
                    panel_equipement.add(Equip_checkBox4);
                    panel_equipement.add(Equip_checkBox5);
                    panel_equipement.add(Equip_checkBox6);
                    panel_equipement.add(Equip_checkBox7);
                    panel_equipement.add(Equip_checkBox8);
                    panel_equipement.add(Equip_checkBox9);
                    panel_equipement.add(Equip_checkBox10);
                    panel_equipement.add(Equip_checkBox11);
                    panel_equipement.add(Equip_checkBox12);
                    panel_equipement.add(Equip_checkBox13);
                    panel_equipement.add(Equip_checkBox14);
                    panel_equipement.add(Equip_checkBox15);
                    panel_equipement.add(Equip_checkBox16);
                    panel_equipement.add(Equip_checkBox17);
                    panel_equipement.add(Equip_checkBox18);
                    panel_equipement.add(Equip_checkBox19);
                    panel_equipement.add(Equip_checkBox20);
                    panel_equipement.add(Equip_checkBox21);
                    panel_equipement.add(Equip_checkBox22);
                    panel_equipement.add(Equip_checkBox23);
                    panel_equipement.add(Equip_checkBox24);
                    panel_equipement.add(Equip_checkBox25);
                    panel_equipement.add(Equip_checkBox26);
                    panel_equipement.add(info);
                    panel_equipement.add(equipement_terminer);

                });

                game_panel.add(game_label1);
                game_panel.add(game_label2);
                game_panel.add(game_label3);
                game_panel.add(game_label4);
                game_panel.add(game_label5);
                game_panel.add(meteo_interne1);
                game_panel.add(meteo_interne2);
                game_panel.add(meteo_interne3);
                game_panel.add(meteo_externe1);
                game_panel.add(meteo_externe2);
                game_panel.add(meteo_externe3);
                game_panel.add(temps);
                game_panel.add(label_consommation);
                game_panel.add(bouton_boutique);
                game_panel.add(bouton_equipements);

                int heure = Integer.parseInt(dateFormat.format(time).substring(0, 2));
                if (heure == 0) {
                    j.setNombre_jour_survie();
                    if (smart_home.getConsommationtotale() >= 9000){
                        j.setRetrait(1000);
                    }
                    j.setGain(200);
                    smart_home.setConsommationtotale(0);
                }

                time.setTime(time.getTime() + 3600000);

            }

        });

        thread.start();

    }

}


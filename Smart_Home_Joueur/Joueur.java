package Smart_Home_Joueur;
import Smart_Home_Systeme.Boutique;
import Smart_Home_Systeme.Equipements_energetiques;
import java.util.ArrayList;


public class Joueur {
    private int nombre_jour_survie;
    private String pseudo;
    private double argent;
    private Boutique boutique;

    public Joueur(){
        this.nombre_jour_survie = 0;
        this.pseudo = "Player";
        this.argent = 25000.0;
        this.boutique = new Boutique();
    }

    public Joueur(String p){
        this.nombre_jour_survie = 0;
        this.pseudo = p;
        this.argent = 25000.0;
        this.boutique = new Boutique();
    }

    public int getNbJourSurvie(){
        return nombre_jour_survie;
    }

    public double getArgent() {
        return argent;
    }

    public void setPseudo(String p) {
        pseudo = p;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setNombre_jour_survie() {
        this.nombre_jour_survie += 1;
    }

    public void setRetrait(double arg){
        this.argent -= arg;
    }

    public void setGain(double arg) {
        this.argent += arg;
    }

    public void AcheterEquip(Equipements_energetiques EE, ArrayList<Equipements_energetiques> tab_EE) {
        tab_EE.add(EE);
        EE.setEstAchete(true);
        this.argent -= EE.getPrix();
    }

}

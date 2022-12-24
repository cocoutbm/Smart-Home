package Smart_Home_Joueur;
import Smart_Home_Syteme.*;
public class Joueur {
    protected int nombre_jour_survie;
    protected String pseudo;
    protected double argent;
    protected Maison MaMaison;
    public Joueur(){
        this.nombre_jour_survie = 0;
        this.pseudo = "Player";
        this.argent = 25000.0;
    }

    public void lancerPartie() {
        this.MaMaison = new Maison();

        while (this.nombre_jour_survie <14) {

        }


        }

    public Joueur(int nb, String p, double a){
        this.nombre_jour_survie = nb;
        this.pseudo = p;
        this.argent = a;
    }


}

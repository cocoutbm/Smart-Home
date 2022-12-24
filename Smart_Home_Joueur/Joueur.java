package Smart_Home_Joueur;

public class Joueur {
    private int nombre_jour_survie;
    private String pseudo;
    private double argent;

    public Joueur(){
        this.nombre_jour_survie = 0;
        this.pseudo = "Player";
        this.argent = 25000.0;
    }

    public Joueur(int nb, String p, double a){
        this.nombre_jour_survie = nb;
        this.pseudo = p;
        this.argent = a;
    }
}

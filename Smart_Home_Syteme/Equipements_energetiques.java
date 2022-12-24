package Smart_Home_Syteme;

public class Equipements_energetiques {
    protected String nom;
    protected double prix;
    protected double consommation;

    public Equipements_energetiques(){
        this.nom = "EE";
        this.prix = 0.0;
        this.consommation = 0.0;
    }

    public Equipements_energetiques(String n, double p, double c){
        this.nom = n;
        this.prix = p;
        this.consommation = c;
    }
}

package Smart_Home_Systeme;

public class Equipements_domestiques {
    protected String nom;
    protected double consommation;
    private boolean estUtilise;

    public Equipements_domestiques(){
        this.nom="ED";
        this.consommation=0.0;
        this.estUtilise = false;
    }
    public Equipements_domestiques(String nom, float consommation, boolean use) {
        this.nom = nom;
        this.consommation = consommation;
        this.estUtilise = use;
    }

    public void ustiliserEquipementsDomestiques(boolean use) {
        this.estUtilise = use;
    }

    public void showEquipementsDomestiques() {
        System.out.println("    nom: " + nom + ", consommation: " + consommation + ".");
    }

    public double getConsommation() {
        if (estUtilise){
            return consommation;
        } else {
            return 0;
        }
    }

    public boolean isEstUtilise(){
        return estUtilise;
    }
}
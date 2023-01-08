package Smart_Home_Systeme;

public class Equipements_energetiques {
    private String nom;
    private double prix;
    private double consommation;
    private boolean estUtilise;
    private boolean estAchete;

    public Equipements_energetiques(){
        this.nom = "EE";
        this.prix = 0.0;
        this.consommation = 0.0;
        this.estUtilise = false;
        this.estAchete = false;

    }

    public Equipements_energetiques(String n, double p, double c, boolean use, boolean achete){
        this.nom = n;
        this.prix = p;
        this.consommation = c;
        this.estUtilise = use;
        this.estAchete = achete;

    }

    public void utiliserEquipementsEnergetiques(boolean use) {
        this.estUtilise = use;
    }

    public void showEquipementsEnergetiques(){
        System.out.println(" nom: " + nom + ", prix: " + prix + " €, consommation: " + consommation + ".");
    }

    public double getPrix() {
        return prix;
    }


    public void setEstAchete(boolean achete){
        this.estAchete = achete;
    }

    public boolean isEstAchete(){
        return estAchete;
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


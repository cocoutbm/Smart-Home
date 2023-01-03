package Smart_Home_Systeme;

public class Equipements_energetiques {
    private String nom;
    private double prix;
    private double consommation;
    private boolean estUtilise;

    public Equipements_energetiques(){
        this.nom = "EE";
        this.prix = 0.0;
        this.consommation = 0.0;
        this.estUtilise = false;

    }

    public Equipements_energetiques(String n, double p, double c, boolean use){
        this.nom = n;
        this.prix = p;
        this.consommation = c;
        this.estUtilise = use;

    }

    public void utiliserEquipementsEnergetiques() {
        System.out.println("L'équipement énergétique: " + nom + " est entrain d'être utilise");
    }

    public void showEquipementsEnergetiques(){
        System.out.println(" nom: " + nom + ", prix: " + prix + " €, consommation: " + consommation + ".");
    }

    public double getPrix() {
        return prix;
    }

    public double getConsommation() {
        return consommation;
    }
}


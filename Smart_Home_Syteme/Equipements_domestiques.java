package Smart_Home_Syteme;

public class Equipements_domestiques {
    protected String nom;
    protected double consommation;

    public Equipements_domestiques(){
        this.nom="ED";
        this.consommation=0.0;
    }
    public Equipements_domestiques(String nom, float consommation) {
        this.nom = nom;
        this.consommation = consommation;
    }

    public void utiliserEquipementDomestique() {
        System.out.println("L'équipement domestique " + nom + " est en train d'être utilisé.");
    }
}